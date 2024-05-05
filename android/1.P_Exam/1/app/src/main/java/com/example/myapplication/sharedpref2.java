package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sharedpref2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref2);
        EditText et1=findViewById(R.id.key);
        EditText et2=findViewById(R.id.val);
        Button w=findViewById(R.id.write);
        Button c=findViewById(R.id.clear);
        Button r=findViewById(R.id.read);
        Button d=findViewById(R.id.del);
        SharedPreferences shared_Pref=getSharedPreferences("my_pref1",MODE_PRIVATE);
        SharedPreferences.Editor editor=shared_Pref.edit();
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=et1.getText().toString();
                String val=et2.getText().toString();
                editor.putString(key,val);
                editor.commit();
                Toast.makeText(sharedpref2.this, "w!", Toast.LENGTH_SHORT).show();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                Toast.makeText(sharedpref2.this, "c!", Toast.LENGTH_SHORT).show();
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=et1.getText().toString();
                String val=shared_Pref.getString(key,null);
                et2.setText(val);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=et1.getText().toString();
                editor.remove(key);
                editor.commit();
                Toast.makeText(sharedpref2.this, "d!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}