package com.example.biotiapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper (Context context){
        super(context, "Userdata.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(name TEXT primary key, scale INT, pos INT)");
        db.execSQL("create Table MeasureDetails(name TEXT primary key, date TEXT, time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Userdetails");
        //db.execSQL("drop Table if exists MeasureDetails");
    }

    public Boolean insertuserdata(String name, int scale, int pos){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("scale",scale);
        cv.put("pos",pos);
        long result = DB.insert("Userdetails",null,cv);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public String getScale(String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        String[] tname = {name};
        Cursor cursor = DB.rawQuery("SELECT scale FROM Userdetails WHERE name = ?",tname);
        cursor.moveToFirst();
        //return Integer.parseInt(cursor.getString(0));
        return cursor.getString(cursor.getColumnIndex("scale"));
    }

    public String getPos(String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        String[] tname = {name};
        Cursor cursor = DB.rawQuery("SELECT pos FROM Userdetails WHERE name = ?",tname);
        cursor.moveToFirst();
        //return Integer.parseInt(cursor.getString(0));
        return cursor.getString(cursor.getColumnIndex("pos"));
    }



    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }

    public void clearDatabase(String tableName){
        SQLiteDatabase DB = this.getWritableDatabase();
        String clear = "DELETE FROM "+ tableName;
        DB.execSQL(clear);
    }

/*
    public Boolean updateuserdata(String name, int scale, int pos){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("scale",scale);
        cv.put("pos",pos);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0){

        }
        long result = DB.update("Userdetails",cv,"name=?", new String[] {name});
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }*/


}
