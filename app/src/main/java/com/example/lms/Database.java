package com.example.lms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(sid text primary key, sname text, email text, pass text, role text)";
        String qry2 = "create table booklist(bookid text primary key, bookname text, author text, category text, available text)";
        sqLiteDatabase.execSQL(qry1);
        sqLiteDatabase.execSQL(qry2);
        addDefaultAdmin(sqLiteDatabase); //Default Admin user
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void addDefaultAdmin(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("sid", "1");
        values.put("sname", "admin");
        values.put("email", "admin@example.com");
        values.put("pass", "admin");
        values.put("role", "admin");
        db.insert("users", null, values);
    }
    public void addBook(String b_id, String b_name, String b_author, String b_cat, String b_stock)
    {
        ContentValues cv= new ContentValues();
        cv.put("bookid", b_id);
        cv.put("bookname", b_name);
        cv.put("author", b_author);
        cv.put("category", b_cat);
        cv.put("available", b_stock);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("booklist", null, cv);
        db.close();
    }

    public Cursor getBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery("SELECT * FROM booklist", null);
        }
        if (db != null) {
            db.close();
        }
        return cursor;
    }
    public void register(String sname, String sid, String email, String pass, String role)
    {
        ContentValues cv= new ContentValues();
        cv.put("sid", sid);
        cv.put("sname", sname);
        cv.put("email", email);
        cv.put("pass", pass);
        cv.put("role", role);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    public int login(String sid, String pass){
        int result = 0;
        String str []= new String[2];
        str[0] = sid;
        str[1] = pass;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where sid=? and pass=?", str);
        if(c.moveToFirst()){
            String role = c.getString(c.getColumnIndexOrThrow("role"));
            if ("user".equals(role)) {
                result = 1;
            } else if ("admin".equals(role)) {
                result = 2;
            }
        }
        return result;
    }
    public String getUsername(String sid) {
        String username = "";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select sname from users where sid=?", new String[]{sid});
        if (c.moveToFirst()) {
            username = c.getString(c.getColumnIndexOrThrow("sname"));
        }
        return username;
    }
}
