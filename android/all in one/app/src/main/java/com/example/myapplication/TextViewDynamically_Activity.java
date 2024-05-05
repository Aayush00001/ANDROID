package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextViewDynamically_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_dynamically);
        LinearLayout l1=findViewById(R.id.l1);
        TextView tv=new TextView(this);
        tv.setText("hi");
        tv.setTextSize(30);
        tv.setTextColor(getResources().getColor(R.color.black));
        l1.addView(tv);
        Button b=new Button(this);
        b.setText("Add Textview");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv=new TextView(getApplicationContext());
                tv.setText("hi");
                tv.setTextSize(30);
                tv.setTextColor(getResources().getColor(R.color.black));
                l1.addView(tv);
            }
        });
        l1.addView(b);
    }
}