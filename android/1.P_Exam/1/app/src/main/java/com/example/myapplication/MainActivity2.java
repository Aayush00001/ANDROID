package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbhelp1 db=new dbhelp1(MainActivity2.this);
        EditText id=findViewById(R.id.id);
        EditText name=findViewById(R.id.name);
        TextView tv=findViewById(R.id.t1);
        Button i=findViewById(R.id.insert);
        Button v=findViewById(R.id.view);
        Button u=findViewById(R.id.update);
        Button d=findViewById(R.id.delete);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertdata(name.getText().toString());
                Toast.makeText(MainActivity2.this, "i", Toast.LENGTH_SHORT).show();
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=db.viewall();
                while (c.moveToNext())
                {
                    tv.setText(tv.getText().toString()+""+c.getString(0)+""+c.getString(1));
                }
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updatedata(name.getText().toString(),id.getText().toString());
                Toast.makeText(MainActivity2.this, "u", Toast.LENGTH_SHORT).show();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deldata(id.getText().toString());
                Toast.makeText(MainActivity2.this, "d", Toast.LENGTH_SHORT).show();
            }
        });
    }
}