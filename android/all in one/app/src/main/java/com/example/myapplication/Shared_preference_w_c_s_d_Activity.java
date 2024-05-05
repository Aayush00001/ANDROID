package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Shared_preference_w_c_s_d_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_wc_sd);
        EditText et=findViewById(R.id.editTextText);
        EditText et1=findViewById(R.id.editTextText2);
        Button b1=findViewById(R.id.button1);
        Button b2=findViewById(R.id.button2);
        Button b3=findViewById(R.id.button3);
        Button b4=findViewById(R.id.button4);
        SharedPreferences shared_pref=getSharedPreferences("my-pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=shared_pref.edit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=et.getText().toString();
                String value=et1.getText().toString();
                editor.putString(key,value);
                editor.commit();
                Toast.makeText(Shared_preference_w_c_s_d_Activity.this, "INserted!!!", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                Toast.makeText(Shared_preference_w_c_s_d_Activity.this, "Cleared!!", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=et.getText().toString();
                String value=shared_pref.getString(key,null);
                et1.setText(value);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=et.getText().toString();
                editor.remove(key);
                editor.commit();
                Toast.makeText(Shared_preference_w_c_s_d_Activity.this, "Deleted!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}