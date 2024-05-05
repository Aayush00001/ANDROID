package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class dataparsingrestfulapiActivity extends AppCompatActivity {
    String url_API="http://localhost/a/data.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataparsingrestfulapi);
        new syncData().execute(url_API);
    }
    public class syncData extends AsyncTask<String,String,String>
    {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(url_API);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();
                BufferedReader  r=new BufferedReader(new InputStreamReader(con.getInputStream()));
                while(true){
                    String readlines=r.readLine();
                    String data=readlines;
                    if(data==null){
                        break;
                    }

                    Log.d("data",data);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

}
