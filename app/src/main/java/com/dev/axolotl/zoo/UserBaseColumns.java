package com.dev.axolotl.zoo;

import android.provider.BaseColumns;

/**
 * Created by xavierbauquet on 17/04/2016.
 */
public class UserBaseColumns implements BaseColumns{

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_PASS = "pass";
    public static final String COLUMN_AUTHORITY = "authority";

}
