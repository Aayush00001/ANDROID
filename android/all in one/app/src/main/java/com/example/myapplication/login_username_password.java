package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_username_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_username_password);
        EditText etn1=findViewById(R.id.etn1);
        EditText etp1=findViewById(R.id.etp1);
        EditText ete1=findViewById(R.id.ete1);
        Button b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etn1.getText().toString();
                String password = etp1.getText().toString();
                String email = ete1.getText().toString();
                String message = "Username: " + username + "\nPassword: " + password + "\nEmail: " + email;

                Toast.makeText(login_username_password.this,message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}