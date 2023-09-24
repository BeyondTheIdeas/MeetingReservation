package com.vumscs.meetingreservation;

import android.content.Context;
import android.content.SharedPreferences;

public class UsersSessionManager {
    private static final  String PREF_NAME = "UserSessionPref";
    private static final  String KEY_USER_ID = "user_id";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public UsersSessionManager(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void saveUserId(int userId)
    {
        editor.putInt(KEY_USER_ID, userId);
        editor.apply();
    }

    public int getUserId()
    {
        return sharedPreferences.getInt(KEY_USER_ID,-1);
    }

    public void clearSession()
    {
        editor.clear();
        editor.apply();
    }
}
