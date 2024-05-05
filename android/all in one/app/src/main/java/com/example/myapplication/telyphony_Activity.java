package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class telyphony_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telyphony);
        Button b = findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(telyphony_Activity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(telyphony_Activity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, 0);
                } else {
                    TelephonyManager telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                    String ProviderName = telManager.getSimOperatorName();
                    String OpName = telManager.getNetworkOperatorName();
                    int state = telManager.getCallState();
                    Toast.makeText(telyphony_Activity.this, ProviderName + " " + OpName + " " + state, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}