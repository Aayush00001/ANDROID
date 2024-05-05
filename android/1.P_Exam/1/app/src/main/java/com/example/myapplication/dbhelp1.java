package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelp1 extends SQLiteOpenHelper {
    public dbhelp1(@Nullable Context context) {
        super(context, "mydb1",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table std1(id integer primary key autoincrement,name text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertdata(String nm)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",nm);
        db.insert("std1",null,cv);
    }
    public Cursor viewall()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("select * from std1",null);
        return c;
    }
    public void updatedata(String nm,String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",nm);
        db.update("std1",cv,"id=?",new String[]{id});
    }
    public void deldata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("std1","id=?",new String[]{id});
    }
}
