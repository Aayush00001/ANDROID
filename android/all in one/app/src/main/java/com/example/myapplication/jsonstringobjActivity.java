package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class jsonstringobjActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonstringobj);
        Button b=findViewById(R.id.b1);
        TextView tv=findViewById(R.id.tv1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String JSON_STRING = "{\"employee\":{\"name\":\"aayush\",\"salary\":65000}}";
                try {

                    JSONObject obj = new JSONObject(JSON_STRING);

                    JSONObject employee = obj.getJSONObject("employee");
                    String name = employee.getString("name");
                    String salary = employee.getString("salary");

                    tv.setText("Name: "+name+"Salary: "+salary);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}