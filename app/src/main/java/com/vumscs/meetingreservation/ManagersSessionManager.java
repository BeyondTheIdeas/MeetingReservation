package com.vumscs.meetingreservation;

import android.content.Context;
import android.content.SharedPreferences;

public class ManagersSessionManager {
    private static final  String PREF_NAME = "ManagerSessionPref";
    private static final  String KEY_USER_ID = "manager_id";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public ManagersSessionManager(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveManagerId(int managerId)
    {
        editor.putInt(KEY_USER_ID, managerId);
        editor.apply();
    }

    public int getManagerId()
    {
        return sharedPreferences.getInt(KEY_USER_ID,-1);
    }

    public void clearSession()
    {
        editor.clear();
        editor.apply();
    }
}
