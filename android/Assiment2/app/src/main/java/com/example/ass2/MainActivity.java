package com.example.ass2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText enrollmentEditText;
    private EditText nameEditText;
    private EditText semester1EditText;
    private EditText semester2EditText;
    private EditText semester3EditText;
    private EditText semester4EditText;
    private EditText semester5EditText;
    private EditText semester6EditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enrollmentEditText = findViewById(R.id.enrollmentEditText);
        nameEditText = findViewById(R.id.nameEditText);
        semester1EditText = findViewById(R.id.semester1EditText);
        semester2EditText = findViewById(R.id.semester2EditText);
        semester3EditText = findViewById(R.id.semester3EditText);
        semester4EditText = findViewById(R.id.semester4EditText);
        semester5EditText = findViewById(R.id.semester5EditText);
        semester6EditText = findViewById(R.id.semester6EditText);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput()) {
                    navigateToResultScreen();
                }
            }
        });
    }
    private boolean validateInput() {
        // Check if all fields are filled
        if (TextUtils.isEmpty(enrollmentEditText.getText().toString()) ||
                TextUtils.isEmpty(nameEditText.getText().toString()) ||
                TextUtils.isEmpty(semester1EditText.getText().toString()) ||
                TextUtils.isEmpty(semester2EditText.getText().toString())||
                TextUtils.isEmpty(semester3EditText.getText().toString()) ||
                TextUtils.isEmpty(semester4EditText.getText().toString()) ||
                TextUtils.isEmpty(semester5EditText.getText().toString()) ||
                TextUtils.isEmpty(semester6EditText.getText().toString())) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validate the format of Semester marks (numeric values)
        if (!isNumeric(semester1EditText.getText().toString()) ||
                !isNumeric(semester2EditText.getText().toString())) {
            Toast.makeText(this, "Enter valid numeric marks", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Add similar checks for Semester 3 to 6

        return true;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void navigateToResultScreen() {
        Intent intent = new Intent(this, ResultActivity.class);

        // Pass data to ResultActivity
        intent.putExtra("enrollment", enrollmentEditText.getText().toString());
        intent.putExtra("name", nameEditText.getText().toString());
        intent.putExtra("semester1", semester1EditText.getText().toString());
        intent.putExtra("semester2", semester2EditText.getText().toString());
        intent.putExtra("semester3", semester3EditText.getText().toString());
        intent.putExtra("semester4", semester4EditText.getText().toString());
        intent.putExtra("semester5", semester5EditText.getText().toString());
        intent.putExtra("semester6", semester6EditText.getText().toString());
        startActivity(intent);
    }
}