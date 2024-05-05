package com.example.ass2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ass2_4 extends AppCompatActivity {

    EditText no1, no2;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ass24);

        no1 = findViewById(R.id.first_no);
        no2 = findViewById(R.id.second_no);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void performOperation(View view) {
        double a = Double.parseDouble(no1.getText().toString());
        double b = Double.parseDouble(no2.getText().toString());
        double ans = 0;

        if (view.getId() == R.id.add) {
            ans = a + b;
        } else if (view.getId() == R.id.subtract) {
            ans = a - b;
        } else if (view.getId() == R.id.multiply) {
            ans = a * b;
        } else if (view.getId() == R.id.divide) {
            if (b != 0) {
                ans = a / b;
            } else {
                resultTextView.setText("Cannot divide by zero");
                return;
            }
        }

        resultTextView.setText(String.valueOf(ans));
    }
}