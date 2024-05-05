package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Internet_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        Button b=findViewById(R.id.b1);
        WebView w=findViewById(R.id.wv1);
        if (ContextCompat.checkSelfPermission(Internet_Activity.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Internet_Activity.this, new String[]{Manifest.permission.INTERNET}, 0);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load external link
                //w.setWebViewClient(new webviewclient());
                //w.loadUrl("https://www.w3schools.com");


                //local webpage stored in asset directory
                //w.loadUrl("file:///android_asset/1.jpg");


                //load html content
                //String data="<html><body><h1>hello</h1></body></html>";
                //w.loadData(data,"text/html","utf-8");
            }
        });
    }
}