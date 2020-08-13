package com.example.sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String Database_Name = "UserDB.db";
    private static final String Table_Name = "User_Table";
    private static final String Col_1 = "ID";
    private static final String Col_2 = "NAME";
    private static final String Col_3 = "SURNAME";
    private static final String Col_4 = "MARKS";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Database_Name, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
     }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "create table " + Table_Name + "(ID INTEGER PRIMARY KEY , NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +Table_Name);
        onCreate(sqLiteDatabase);
    }

    public boolean InsertUser(String id ,String name, String email, String phone){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,id);
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,email);
        contentValues.put(Col_4,phone);
        long result = sqLiteDatabase.insert(Table_Name,null,contentValues);
        if (result == -1){
            return  false;
        }
        else {
            return true;
        }
    }
}
