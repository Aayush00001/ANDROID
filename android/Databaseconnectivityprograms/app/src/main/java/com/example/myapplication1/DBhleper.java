package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhleper extends SQLiteOpenHelper {
    public DBhleper(@Nullable Context context) {
        super(context,"MYdb1",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE std1(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertdata(){
        SQLiteDatabase db=this.getWritableDatabase();
       // db.execSQL("Insert Into std1 values(1,'aayush')");
        ContentValues cv=new ContentValues();
       // cv.put("ID",1);
        cv.put("NAME","aayush");
        db.insert("std1",null,cv);
    }
    public Cursor viewData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM std1",null);
        return c;
    }
    public void updatedata(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NAME","soni");
        db.update("std1",cv,"ID=?",new String[]{"29"});
    }
    public void deletedata(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("std1","ID=?",new String[]{"31"});
    }
    public void clearAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("std1", null, null);
        db.close();
    }
}