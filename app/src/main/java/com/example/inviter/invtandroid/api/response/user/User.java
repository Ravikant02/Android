package com.example.inviter.invtandroid.api.response.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

/**
 * Created by Inwiter on 11/04/16.
 */
public class User {
    public UserPayment userPayment;
    public UserProfile userProfile;
    public UserAPIKeys userAPIKeys;
    public String userID;
    public String selectedEventID;

    private  static User user;

    private static String KEY_CURRENT_USER;
    public static User getInstance()
    {
        if (user == null) {
            user = new User();
        }

        return user;

    }
    public static void saveUser(Context context, User user)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString(KEY_CURRENT_USER, new Gson().toJson(user));
    }
    public static User getUser(Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return new Gson().fromJson(preferences.getString(KEY_CURRENT_USER, null), User.class);
    }
}
