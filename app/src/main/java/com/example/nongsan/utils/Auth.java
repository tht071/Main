package com.example.nongsan.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Auth {
    private static Auth instance;
    private SharedPreferences sharedPreferences;
    private final String AUTHENTICATION = "authentication";

    private Auth(Context context){
        sharedPreferences = context.getSharedPreferences("MySharedPref",Context.MODE_PRIVATE);
    }

    public static Auth getInstance(Context context){
        if(instance == null) instance = new Auth(context);
        return instance;
    }

    public void setAuthentication(boolean bool){
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putBoolean(AUTHENTICATION, bool);
        myEdit.commit();
    }

    public boolean getAuthentication(){
        return sharedPreferences.getBoolean(AUTHENTICATION, false);
    }
}
