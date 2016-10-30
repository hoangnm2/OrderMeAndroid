package com.android.orderme;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.com.android.service.UserService;
import com.android.entity.User;
import com.android.utils.API;
import com.google.gson.Gson;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private Button mEmailSignInButton;
    private TextView errorLog;

    ProgressDialog progressDialog;


    private static User user;
    private static boolean res;
    private static Logger logger = Logger.getLogger("UserService");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        errorLog = (TextView) findViewById(R.id.errorLog);
        errorLog.setVisibility(View.INVISIBLE);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });


        //TODO: remove hardcode
        mEmailView.setText("minhhoang@gmail.com");
        mPasswordView.setText("12345678");
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Doi ti di");
            progressDialog.setCancelable(false);
            progressDialog.show();
            boolean res = authenticate(getApplicationContext(), email, password);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private boolean authenticate(Context context, String email, String password) {

        progressDialog.show();
        User userReq = new User();
        userReq.setEmail(email);
        userReq.setPassword(password);

        Ion.with(context)
                .load(API.LOGIN)
                .setJsonPojoBody(userReq)
                .asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    progressDialog.hide();
                    if (e != null || result == null) {
                        res = false;
                        errorLog.setVisibility(View.VISIBLE);
                        errorLog.setText("Email and password is incorrect.");
                        logger.severe("Fail to login");
                        return;
                    }
                    Gson gson = new Gson();
                    user = gson.fromJson(result, User.class);
                    if (user != null) {
                        res = true;
                        Intent i = new Intent(getApplicationContext(), WelcomeActitvity.class);
                        startActivity(i);
                        logger.info("Called API and login successfully");
                    }
                } catch (Exception ex) {
                    res = false;
                    errorLog.setVisibility(View.VISIBLE);
                    errorLog.setText("Email and password is incorrect.");
                    logger.severe("Fail to login. Exception occurred");
                }
            }
        });

        //TODO: set name to sharePreference (Session management)

        return res;
    }
}

