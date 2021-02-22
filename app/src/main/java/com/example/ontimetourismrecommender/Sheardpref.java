package com.example.ontimetourismrecommender;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.*;
import com.android.volley.toolbox.Volley;

public class Sheardpref {

        private static Sheardpref instance;
        private static Context ctx;
    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";


        private Sheardpref(Context context) {
            ctx = context;

        }

        public static synchronized Sheardpref getInstance(Context context) {
            if (instance == null) {
                instance = new Sheardpref(context);
            }
            return instance;
        }
    public boolean userLogin(String username ){

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString(KEY_USERNAME, username);

        editor.apply();

        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null) != null){
            return true;
        }
        return false;
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
    public String getUsername(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null);
    }



    /*private static Sheardpref minstance;
    private static Context mCtx;
private Sheardpref(Context context){
    mCtx=context;
}*/
}
