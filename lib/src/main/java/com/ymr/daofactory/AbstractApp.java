package com.ymr.daofactory;

import android.app.Application;

/**
 * Created by ymr on 15/4/17.
 */
public abstract class AbstractApp extends Application {

    private static AbstractApp sContext;
    private DaoHelper mDaoHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoHelper = getSubDaoHelper();
        sContext = this;
    }

    protected abstract DaoHelper getSubDaoHelper();

    public static AbstractApp getContext() {
        return sContext;
    }

    public DaoHelper getDaoHelper(){
        return mDaoHelper;
    }
}
