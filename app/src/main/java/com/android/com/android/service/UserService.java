package com.android.com.android.service;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.entity.User;
import com.android.utils.API;
import com.google.gson.Gson;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.logging.Logger;

/**
 * Created by Hoang on 10/29/16.
 */

public class UserService {

    private static User user;
    private static boolean res;
    private static Logger logger = Logger.getLogger("UserService");

    public static boolean authenticate(Context context, final ProgressDialog progressDialog, String email, String password) {

        User userReq = new User();
        userReq.setEmail(email);
        userReq.setPassword(password);

        Ion.with(context)
                .load(API.LOGIN)
                .setJsonPojoBody(userReq)
                .asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try {
                    progressDialog.hide();
                    if (e != null || result == null) {
                        res = false;
                        logger.severe("Fail to login");
                        return;
                    }
                    Gson gson = new Gson();
                    user = gson.fromJson(result, User.class);
                    if (user != null) {
                        res = true;
                        logger.info("Called API and login successfully");
                    }
                } catch (Exception ex) {
                    res = false;
                    logger.severe("Fail to login. Exception occurred");
                }
            }
        });

        //TODO: set name to sharePreference (Session management)

        return res;
    }

}
