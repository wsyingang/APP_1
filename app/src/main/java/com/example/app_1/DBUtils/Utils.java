package com.example.app_1.DBUtils;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.app_1.beans.*;


public class Utils {
    public static boolean Insert(SQLiteDatabase db, people p){
        String SQL="INSERT INTO user(name,passwd,sex)values("+p.getName()+","+p.getPwd()+","+p.getSex()+")";
        try{
            db.execSQL(SQL);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    // 删除
    public static boolean DeleteByname(SQLiteDatabase db,people p) {
        String SQL = "DELETE FROM user WHERE name=" + p.getName();
        try {
            db.execSQL(SQL);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    // 登录验证
    public  static boolean verify(SQLiteDatabase db, String name,String passwd){
        String S="SELECT * FROM user";
        Cursor cursor=db.rawQuery(S,null);
        if(cursor!=null&&cursor.getCount()>0){
            String uname=cursor.getString(1);
            String pwd=cursor.getString(2);
            if(uname.equals(name)&&passwd.equals(pwd))return true;
        }
        return false;
    }
}
