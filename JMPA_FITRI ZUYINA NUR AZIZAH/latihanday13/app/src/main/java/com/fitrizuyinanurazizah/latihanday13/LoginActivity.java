package com.fitrizuyinanurazizah.latihanday13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fitrizuyinanurazizah.latihanday13.model.Session;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edUsername;
    private EditText edPassword;
    private Session session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = Application.getSession();

        edUsername.setText("");
        edPassword.setText("");

        if (session.isKeepUsername()) {
            edUsername.setText(session.getUsername());
        }



    }

    @Override
    public void onClick(View v) {
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();

        boolean success = session.validate(username, password);
        if (success) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Snackbar.make(view, "Authentication Failed", Snackbar.LENGTH_SHORT).show();
        }
        if (success) {
            if (session.isKeepUsername()) {
                session.setUsername(username);
            }

            // logika code yang lain...
            // ...
        }


    }
}
