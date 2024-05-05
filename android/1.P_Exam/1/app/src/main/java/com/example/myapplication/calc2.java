package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class calc2 extends AppCompatActivity {
    EditText num1,num2;
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc2);
        num1=findViewById(R.id.number1);
        num2=findViewById(R.id.number2);
        ans=findViewById(R.id.answer);
        Button a=findViewById(R.id.add);
        Button s=findViewById(R.id.sub);
        Button m=findViewById(R.id.mul);
        Button d=findViewById(R.id.div);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("+");
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("-");
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("*");
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("/");
            }
        });
    }
    private void calc(String operator){
        double num1value=Double.parseDouble(num1.getText().toString());
        double num2value=Double.parseDouble(num2.getText().toString());
        double result=0;

        switch(operator){
            case "+":
                result =num1value+num2value;
                break;
            case "-":
                result=num1value-num2value;
                break;
            case  "*":
                result=num1value*num2value;
                break;
            case "/":
                if(num2value!=0){
                    result=num1value/num2value;
                }else{
                    ans.setText("cannot dive by zero");
                    return;
                }
                break;
        }
        ans.setText("answer:"+result);
    }
}