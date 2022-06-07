package com.mekan_myradov.cityguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "cityguide.db";

    public DBHelper(Context context) {
        super(context, "cityguide.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(id INT PRIMARY KEY, email TEXT, password TEXT)");
        db.execSQL("CREATE TABLE reviews(id INT PRIMARY KEY, rating INT, venue_title TEXT, author TEXT, review_date TEXT, review TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS reviews");
    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);

        // Insertion failed
        if(result == -1){
            return  false;
        }
        else {
            return true;
        }
    }

    public Boolean insertReview(int rating, String venue_title, String author, String review_date, String review){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rating", rating);
        contentValues.put("venue_title", venue_title);
        contentValues.put("author", author);
        contentValues.put("review_date", review_date);
        contentValues.put("review", review);
        long result = db.insert("reviews", null, contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    Cursor readReviews(String venue_title){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("SELECT * FROM reviews WHERE venue_title = ?", new String[] {venue_title});
        }

        return cursor;
    }

    Cursor retrieveFavorites(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("SELECT DISTINCT venue_title FROM reviews WHERE rating > ?", new String[] {"4"});
        }

        return cursor;
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ?", new String[] {email});

        // There is an existing record
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return  false;
        }
    }

    public Boolean checkEmailAndPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ? AND password = ?", new String[] {email, password});

        // There is an existing record
        if(cursor.getCount() > 0){
            return  true;
        }
        else {
            return false;
        }
    }
}
