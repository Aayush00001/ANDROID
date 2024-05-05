package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class Shared_Activity_Ex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_ex);

        //creating a shared preference
        SharedPreferences shared_pref=getSharedPreferences("my-pref",MODE_PRIVATE);
        //SharedPreferences shared_pref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=shared_pref.edit();
        editor.putString("Name","aaayush");
        editor.putInt("Id",001);
        editor.commit();
    }
}