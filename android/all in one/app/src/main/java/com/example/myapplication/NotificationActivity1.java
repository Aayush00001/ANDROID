package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification1);
        Button b=findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(NotificationActivity1.this);


                Intent i = new Intent(getApplicationContext(),NotificationActivity1.class);
                PendingIntent pi = PendingIntent.getActivity(NotificationActivity1.this, 001, i, PendingIntent.FLAG_IMMUTABLE);



                nBuilder.setSmallIcon(R.drawable.ic_launcher_background);
                nBuilder.setContentTitle("TITLE");
                nBuilder.setContentText("TEXT");
                nBuilder.setChannelId("atmiya");
                nBuilder.setContentIntent(pi);
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                @SuppressLint({"NewApi", "LocalSuppress"}) NotificationChannel nc = new NotificationChannel("atmiya","AppName",NotificationManager.IMPORTANCE_DEFAULT);
                nm.createNotificationChannel(nc);
                nm.notify(001,nBuilder.build());

            }
        });
    }
}