package com.dev.axolotl.zoo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by xavierbauquet on 17/04/2016.
 */
public class UserContentProvider extends ContentProvider{

    // URI matcher
    private static final String AUTHORITY = "com.dev.axolotl.zoo";
    private static final String USERS_PATH = "users";
    private static final int USERS_LIST = 0;
    private static final int USERS_DETAILS = 1;
    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    static{
        matcher.addURI(AUTHORITY, USERS_PATH, USERS_LIST);
        matcher.addURI(AUTHORITY, USERS_PATH + "/*", USERS_DETAILS);
    }

    @Override
    public boolean onCreate() {
        UsersDbHelper helper = new UsersDbHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        UsersDbHelper helper = new UsersDbHelper(getContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor result = null;
        int uriType = matcher.match(uri);
        switch (uriType){
            case USERS_LIST: {
                result = db.query(UsersDbHelper.DATABASE_NAME, projection, null, null, null, null, null);
                break;
            }
            case USERS_DETAILS: {
                String[] email = {uri.getLastPathSegment()};

                result = db.query(UsersDbHelper.DATABASE_NAME, projection, "email = ?", email, null, null, null);
                break;
            }
            default: {
                try {
                    throw new IllegalAccessException("Unknown URI: " + uri);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        result.setNotificationUri(getContext().getContentResolver(), uri);

        return result;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
