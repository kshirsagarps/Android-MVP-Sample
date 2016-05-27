package com.example.mvpdemo.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by pratyush on 4/3/16.
 */
public class MVPDemo extends Application {

    private static Context sApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationContext = getApplicationContext();
    }

    public static Context getContext() {
        return sApplicationContext;
    }
}
