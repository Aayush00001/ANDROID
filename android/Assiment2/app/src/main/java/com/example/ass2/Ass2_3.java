package com.example.ass2;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class Ass2_3 extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ass23);

        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Toggle is ON, show image2
                    imageView.setImageResource(R.drawable.a);
                } else {
                    // Toggle is OFF, show image1
                    imageView.setImageResource(R.drawable.b);
                }
            }
        });
    }
}