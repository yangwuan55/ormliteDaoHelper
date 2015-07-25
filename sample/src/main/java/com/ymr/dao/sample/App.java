package com.ymr.dao.sample;

import android.app.Application;

/**
 * Created by ymr on 15/4/17.
 */
public class App extends Application {
    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }

    public static App getApp() {
        return sApp;
    }
}
