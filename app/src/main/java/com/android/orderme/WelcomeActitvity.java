package com.android.orderme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.utils.SessionManagement;

public class WelcomeActitvity extends AppCompatActivity {

    private SessionManagement sessionManagement;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sessionManagement = new SessionManagement(getApplicationContext());

        String name = sessionManagement.getPref().getString("name", null);
        welcome.setText("Hi " + name + ", welcome to OrderMe");
    }
}
