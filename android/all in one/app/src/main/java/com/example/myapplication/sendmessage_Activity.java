package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class sendmessage_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmessage);
        Button b = findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(sendmessage_Activity.this, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED) {
                    try {
                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage("111111111", null, "hi", null, null);
                        Toast.makeText(sendmessage_Activity.this, "Message sent", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(sendmessage_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    ActivityCompat.requestPermissions(sendmessage_Activity.this,
                            new String[]{Manifest.permission.SEND_SMS}, 0);
                }
            }
        });
    }
}