package com.android.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.dao.entry.OMMenu;
import com.android.utils.Constant;

/**
 * Created by Hoang on 11/5/16.
 */

public class SQLiteManager extends SQLiteOpenHelper {

    public SQLiteManager(Context context) {
        super(context, "orderme", null, Constant.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(OMMenu.create());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
