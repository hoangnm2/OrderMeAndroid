package com.android.utils;

import android.text.TextUtils;

/**
 * Created by Administrator on 10/29/2016.
 */

public class ValidationUtils {

    public static boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public static boolean isPasswordValid(String password) {
       return password.length() > 6;
    }

    public static boolean isNotEmpty(String key) {
        if (!TextUtils.isEmpty(key)) {
            return true;
        }
        return false;
    }
}
