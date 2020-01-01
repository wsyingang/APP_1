package com.example.app_1.DBUtils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.app_1.beans.*;
public class DBHelper extends SQLiteOpenHelper {
    //数据库版本
    private static final int DATABASE_VERSION=3;
    //数据库名称
    private static final String DATABASE_NAME="user.db";
    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    // 建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_User="CREATE TABLE User(name TEXT,passwd TEXT,sex INTEGER)";
        db.execSQL(CREATE_TABLE_User);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
        db.execSQL("DROP TABLE IF EXISTS user");
        //再次创建表
        onCreate(db);
    }

//
}