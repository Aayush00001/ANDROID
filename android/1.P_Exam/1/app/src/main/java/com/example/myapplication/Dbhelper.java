package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper(@Nullable Context context) {
        super(context,"mydb",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table std(id integer primary key autoincrement,name text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertdata(String nm)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",nm);
        db.insert("std",null,cv);
    }
    public Cursor viewall()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("select * from std",null);
        return c;
    }
    public  void updatedata(String nm,String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",nm);
        db.update("std",cv,"id=?",new String[]{id});
    }
    public  void deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("std","id=?",new String[]{id});
    }
}
