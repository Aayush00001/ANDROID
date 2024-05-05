package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc extends AppCompatActivity {
    EditText num1,num2;
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        num1=findViewById(R.id.number1);
        num2=findViewById(R.id.number2);
        ans=findViewById(R.id.answer);
        Button add=findViewById(R.id.add);
        Button sub=findViewById(R.id.sub);
        Button mul=findViewById(R.id.mul);
        Button div=findViewById(R.id.div);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("*");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("/");
            }
        });
    }
    private void calc(String operator)
    {
        double num1v=Double.parseDouble(num1.getText().toString());
        double num2v=Double.parseDouble(num2.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = num1v + num2v;
                break;
            case "-":
                result = num1v - num2v;
                break;
            case "*":
                result = num1v * num2v;
                break;
            case "/":
                if (num2v != 0) {
                    result = num1v / num2v;
                } else {
                    ans.setText("Cannot divide by zero!");
                    return;
                }
                break;
        }

        ans.setText("Answer: " + result);
    }
}