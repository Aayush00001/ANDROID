package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Progessbar_horizontal_Activity extends AppCompatActivity {
    private int i = 0;
    private ProgressBar pb;
    private TextView txtView;
    private Handler hdlr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progessbar_horizontal);

        pb = findViewById(R.id.progressBar);
        txtView = findViewById(R.id.textView); // Make sure you have a TextView with the id 'textView' in your layout
        Button b1 = findViewById(R.id.button1);

        hdlr = new Handler();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = pb.getProgress();
                new Thread(new Runnable() {
                    public void run() {
                        while (i < 100) {
                            i += 1;
                            // Update the progress bar and display the current value in text view
                            hdlr.post(new Runnable() {
                                public void run() {
                                    pb.setProgress(i);
                                    txtView.setText(i + "/" + pb.getMax());
                                }
                            });

                            try {
                                // Simulate a delay to see the progress
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }
}
