package com.dev.axolotl.zoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xavierbauquet on 17/04/2016.
 */
public class UsersDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";

    private static final String SQL_CREATE_USERS =
            "CREATE TABLE " + UserBaseColumns.TABLE_NAME + " (" +
                    UserBaseColumns._ID + " INTEGER PRIMARY KEY, " +
                    UserBaseColumns.COLUMN_EMAIL + " TEXT, " +
                    UserBaseColumns.COLUMN_FIRST_NAME + " TEXT, " +
                    UserBaseColumns.COLUMN_LAST_NAME + " TEXT, " +
                    UserBaseColumns.COLUMN_PASS + " TEXT, " +
                    UserBaseColumns.COLUMN_AUTHORITY + " TEXT )";

    public UsersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);

        ContentValues toto = new ContentValues();
        toto.put(UserBaseColumns.COLUMN_EMAIL, "toto@toto.com");
        toto.put(UserBaseColumns.COLUMN_FIRST_NAME, "toto");
        toto.put(UserBaseColumns.COLUMN_LAST_NAME, "toto");
        toto.put(UserBaseColumns.COLUMN_PASS, "toto");
        toto.put(UserBaseColumns.COLUMN_AUTHORITY, "user");

        ContentValues titi = new ContentValues();
        titi.put(UserBaseColumns.COLUMN_EMAIL, "titi@titi.com");
        titi.put(UserBaseColumns.COLUMN_FIRST_NAME, "titi");
        titi.put(UserBaseColumns.COLUMN_LAST_NAME, "titi");
        titi.put(UserBaseColumns.COLUMN_PASS, "titi");
        titi.put(UserBaseColumns.COLUMN_AUTHORITY, "user");

        db.beginTransaction();
        try{
            db.insert(UserBaseColumns.TABLE_NAME, null, toto);
            db.insert(UserBaseColumns.TABLE_NAME, null, titi);
        }finally {
            db.endTransaction();
        }


    }

    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS "
            + UserBaseColumns.TABLE_NAME;

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }
}
