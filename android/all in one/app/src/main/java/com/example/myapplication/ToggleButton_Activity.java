package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleButton_Activity extends AppCompatActivity {
    ToggleButton togglebutton;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        // Initialize class variables with the corresponding views
        togglebutton = findViewById(R.id.toggleButton);
        textview = findViewById(R.id.textView);
    }

    public void onToggleClick(View view) {
        if (togglebutton.isChecked()) {
            textview.setText("Toggle Is ON");
        } else {
            textview.setText("Toggle Is OFF");
        }
    }
}
