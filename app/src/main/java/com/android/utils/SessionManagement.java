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
        editor.putString(SessionParam.USER_EMAIL, user.getEmail());
        editor.putString(SessionParam.USER_NAME, user.getName());
        editor.putString(SessionParam.USER_ROLE, user.getRole().name());
        editor.putBoolean(SessionParam.IS_LOGIN, true);
        editor.commit();

    }

    public SharedPreferences getPref() {
        return pref;
    }

    public void setPref(SharedPreferences pref) {
        this.pref = pref;
    }

    public class SessionParam {
        public static final String USER_EMAIL = "isLogin";
        public static final String USER_NAME = "isLogin";
        public static final String USER_ROLE = "role";
        public static final String IS_LOGIN = "isLogin";
    }
}
