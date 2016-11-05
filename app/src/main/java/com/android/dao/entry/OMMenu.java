package com.android.dao.entry;

import android.provider.BaseColumns;

/**
 * Created by Hoang on 11/5/16.
 */

public class OMMenu {

    public static class Column implements BaseColumns {
        public static final String CATEGORY = "category";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String PRICE = "price";
    }

    public static String create() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + OMMenu.class.getName()).append("( ");
        sb.append(Column._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(Column.NAME + " TEXT, ");
        sb.append(Column.PRICE + " REAL) ");
        return sb.toString();
    }
}
