package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dbhelper db=new Dbhelper(MainActivity.this);
        EditText id=findViewById(R.id.id);
        EditText name=findViewById(R.id.name);
        TextView tv=findViewById(R.id.t1);
        Button insert=findViewById(R.id.insert);
        Button view=findViewById(R.id.view);
        Button update=findViewById(R.id.update);
        Button delete=findViewById(R.id.delete);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertdata(name.getText().toString());
                Toast.makeText(MainActivity.this, "inserted!!!", Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=db.viewall();
                while (c.moveToNext())
                {
                    tv.setText(tv.getText().toString()+""+c.getString(0)+""+c.getString(1));
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updatedata(name.getText().toString(),id.getText().toString());
                Toast.makeText(MainActivity.this, "updated!!", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletedata(id.getText().toString());
                Toast.makeText(MainActivity.this, "deleted!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}