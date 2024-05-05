package com.example.myapplication;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Checkbox_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        CheckBox cb11 = findViewById(R.id.cb1);
        CheckBox cb22 = findViewById(R.id.cb2);
        CheckBox cb33 = findViewById(R.id.cb3);
    }

    public void check_me(View view) {
        int id = view.getId();

        if (id == R.id.cb1) {
            Toast.makeText(this, "Pizza", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cb2) {
            Toast.makeText(this, "Coffee", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cb3) {
            Toast.makeText(this, "Burger", Toast.LENGTH_SHORT).show();
        }
    }
}
