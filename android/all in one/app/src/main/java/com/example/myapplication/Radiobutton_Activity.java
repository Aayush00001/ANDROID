package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Radiobutton_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        RadioButton rb1=findViewById(R.id.rb1);
        RadioButton rb2=findViewById(R.id.rb2);
        Button b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked())
                {
                    Toast.makeText(Radiobutton_Activity.this, "male", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Radiobutton_Activity.this, "female", Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }
}