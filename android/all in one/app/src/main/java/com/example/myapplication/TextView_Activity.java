package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TextView_Activity extends AppCompatActivity {
    private TextView textView;
    private Button colorButton;
    private Button changeTextButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView = findViewById(R.id.textView);
        colorButton = findViewById(R.id.colorButton);
        changeTextButton = findViewById(R.id.changeTextButton);
        editText = findViewById(R.id.editText);

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change TextView background color to red
                textView.setBackgroundColor(Color.RED);
            }
        });

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change TextView text based on EditText input
                String newText = editText.getText().toString();
                textView.setText(newText);
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    // Change TextView text based on EditText input
                    String newText = editText.getText().toString();
                    textView.setText(newText);
                }
            }
        });
    }
}