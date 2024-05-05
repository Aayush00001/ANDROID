package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calc_Activity extends AppCompatActivity {
    EditText no1, no2;
    TextView answer;
    double ans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        no1 = findViewById(R.id.first_no);
        no2 = findViewById(R.id.second_no);
        Button add = findViewById(R.id.add);
        Button equal = findViewById(R.id.equals);
        answer = findViewById(R.id.answer);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(no1.getText().toString());
                double b = Double.parseDouble(no2.getText().toString());
                ans = a + b;
                answer.setText(String.valueOf(ans));
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You can use ans variable here or recalculate the result
                double result = Double.parseDouble(no1.getText().toString()) +
                        Double.parseDouble(no2.getText().toString());
                ans = result;
                answer.setText(String.valueOf(result));
            }
        });
    }
}