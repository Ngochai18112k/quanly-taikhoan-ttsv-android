package com.example.quanlytaikhoanthanhtoansinhvien.TaiKhoan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "MyDatabaseHelper";
    private static final String DATABASE_NAME = "qluser";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "user";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +" ( " +
            COLUMN_USERNAME+" TEXT NOT NULL PRIMARY KEY," +
            COLUMN_PASSWORD+" TEXT NOT NULL" +
            ")";
    private static MyDatabaseHelper sInstance;
    public static MyDatabaseHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new MyDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public MyDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.e(TAG, "onCreate ");
        try{
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "onUpgrade: ");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public List<User> getAllUser(){
        SQLiteDatabase db = getReadableDatabase();
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            do{
                User user = new User();
                user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                users.add(user);
            }while(cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return users;
    }

    public User getUser(String username){
        User user = new User();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_USERNAME+" = '"+username+"';";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
            db.close();
            return user;
        }
        return null;
    }

    public boolean insertUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());
        long rowEffect = db.insert(TABLE_NAME, null, values);
        db.close();
        if(rowEffect != -1){
            return true;
        }
        return false;
    }

    public int deleteUser(User user){
        SQLiteDatabase db = getReadableDatabase();
        int rowEffect = db.delete(TABLE_NAME, COLUMN_USERNAME+" = ?", new String[]{user.getUsername()});
        db.close();
        return rowEffect;
    }

    public int deleteAllUser(){
        SQLiteDatabase db = getReadableDatabase();
        int rowEffect = db.delete(TABLE_NAME, null, null);
        db.close();
        return rowEffect;
    }
}