package com.example.sharedpreferencehakan;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

     private EditText usernameInput;
    private EditText passwordInput;
    private Session session;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = Application.getSession();
        usernameInput.setText("");
        passwordInput.setText("");

    }


    public void onClick(View view) {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        boolean success = session.validate(username, password);
        if (success) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Snackbar.make(view, "Authentication Failed", Snackbar.LENGTH_SHORT).show();

        }
    }
}