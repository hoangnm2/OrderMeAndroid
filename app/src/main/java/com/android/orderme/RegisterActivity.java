package com.android.orderme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.entity.User;
import com.android.utils.API;
import com.android.utils.ValidationUtils;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.logging.Logger;

public class RegisterActivity extends AppCompatActivity {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    TextView errorLog;
    EditText email, name, password1, password2;
    Button registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        errorLog = (TextView) findViewById(R.id.errorLog);
        registerBtn = (Button) findViewById(R.id.btn_register);

        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()) {
                    return;
                }

                User user = new User();
                user.setEmail(email.getText().toString());
                user.setPassword(password1.getText().toString());
                register(getApplicationContext(),user);
            }
        });

    }

    private boolean validate() {
       if (email.getText() == null || TextUtils.isEmpty(email.getText().toString()) || !ValidationUtils.isEmailValid(email.getText().toString())) {
            email.setError("Email is not valid");
            email.requestFocus();
           return false;
        }

        if (name.getText() == null || TextUtils.isEmpty(name.getText().toString())) {
            name.setError("Name is not valid");
            name.requestFocus();
            return false;
        }

        if (password1.getText() == null || TextUtils.isEmpty(password1.getText().toString()) || !ValidationUtils.isPasswordValid(password1.getText().toString())) {
            password1.setError("Password is not valid");
            password1.requestFocus();
            return false;
        }
        String pass1 = password1.getText().toString();

        if (password2.getText() == null || !pass1.equals(password2.getText().toString())) {
            password2.setError("Password does not match");
            password2.requestFocus();
            return false;
        }
        
        return true;
    }

    private void register(Context context, User userReq) {

        Ion.with(context)
                .load(API.REGISTER)
                .setJsonPojoBody(userReq)
                .asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    if (e != null || result == null) {
                        showError(e);
                        return;
                    }
                    Integer res = Integer.parseInt(result);
                    if (res == 1) {
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                    } else {
                        email.setError("Email exists! Please user another email.");
                        email.requestFocus();
                        return;
                    }
                } catch (Exception ex) {
                    showError(e);

                }
            }
        });
    }

    private void showError(Exception e) {
        logger.severe("Fail to register. Exception occurred: " + e.getMessage());
        errorLog.setVisibility(View.VISIBLE);
        errorLog.setText("Fail to register. Please make sure you have connect to internet");
    }
}
