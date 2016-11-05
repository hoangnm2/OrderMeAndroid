package com.android.orderme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.utils.SessionManagement;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WelcomeActitvity extends AppCompatActivity {

    private SessionManagement sessionManagement;
    @InjectView(R.id.tv_welcome) TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.inject(this);

        sessionManagement = new SessionManagement(getApplicationContext());

        if (sessionManagement.getPref() != null) {
            String name = sessionManagement.getPref().getString(SessionManagement.SessionParam.USER_NAME, "John Doe,");
            welcome.setText("Hi " + name + ", welcome to OrderMe");
        }
    }
}
