package com.example.calci;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class helperDataBase extends SQLiteOpenHelper {
    public helperDataBase(Context applicationContext, String dataset, SQLiteDatabase.CursorFactory factory, int version) {
        super(applicationContext, dataset, factory, version );
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table datasetTable(valueOne varChar(20), valueTwo varChar(20), result varChar(20))");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }

    public String ShowData(String a, String b, String result) {
        String data= "";
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("insert into datasetTable values(?,?,?)", new String[]{a,b,result});
        db.close();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from datasetTable", null);

        while(cursor.moveToNext()){
            String valueA = cursor.getString(0);
            String valueB = cursor.getString(1);
            String resultValue = cursor.getString(2);
            data+= valueA+", "+ valueB+", Result ="+resultValue+"\n";
        }
        db.close();
        return data;
    }
}
