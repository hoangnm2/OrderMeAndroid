package com.android.com.android.service;

import android.content.Context;

import com.android.entity.User;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Hoang on 10/29/16.
 */

public class UserService extends RestService {

    private static final String CLASS_API = ROOT_API + "user/";

    public static boolean authenticate(Context context, String email, String password) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setIsOutOfSync(false);

        Ion.with(context)
                .load(CLASS_API + "login")
                .setJsonPojoBody(user)
                .asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    System.err.print(result);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        return false;
    }

}
