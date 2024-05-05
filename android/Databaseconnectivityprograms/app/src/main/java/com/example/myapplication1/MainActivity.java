package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBhleper db=new DBhleper(MainActivity.this);
        Button insert=findViewById(R.id.insertb);
        Button view=findViewById(R.id.viewb);
        Button update=findViewById(R.id.updateb);
        Button delete=findViewById(R.id.deleteb);
        Button clear=findViewById(R.id.clearb);
        TextView tv1=findViewById(R.id.textviwe1);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertdata();
                Toast.makeText(MainActivity.this, "datainserted!!1", Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=db.viewData();
                while(c.moveToNext()){
                    tv1.setText(tv1.getText().toString()+""+c.getString(0)+""+c.getString(1));
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updatedata();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletedata();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("clear!!!");
                db.clearAllData();
            }
        });
    }
}