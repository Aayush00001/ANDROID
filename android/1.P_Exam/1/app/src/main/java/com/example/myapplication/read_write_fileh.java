package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class read_write_fileh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_fileh);
        Button w=findViewById(R.id.write);
        Button r=findViewById(R.id.read);

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos= null;
                try {
                    fos = openFileOutput("myfile.txt",MODE_APPEND);
                    String data="hiii";
                    fos.write(data.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c;
                String data=null;
                FileInputStream fis= null;
                try {
                    fis = openFileInput("myfile.txt");
                    while ((c=fis.read())!=-1)
                    {
                        data=data+Character.toString((char)c);
                    }
                    Toast.makeText(read_write_fileh.this, data, Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }
}