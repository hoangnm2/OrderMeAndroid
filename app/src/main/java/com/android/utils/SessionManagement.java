package com.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.entity.User;

/**
 * Created by Administrator on 10/29/2016.
 */

public class SessionManagement {

    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context context;

    private static final String PREF_NAME = "UserPref";

    public SessionManagement(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void saveLoginSession(User user) {
        editor.putString("email", user.getEmail());
        editor.putString("name", user.getName());
        editor.putBoolean("isLogin", true);
        editor.putString("role", user.getRole().name());
        editor.commit();

    }

    public SharedPreferences getPref() {
        return pref;
    }

    public void setPref(SharedPreferences pref) {
        this.pref = pref;
    }
}
