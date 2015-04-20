package com.ymr.daofactory;

import android.app.Application;
import android.content.Context;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

/**
 * Created by ymr on 15/4/17.
 */
public abstract class AbstractApp extends Application {

    private static AbstractApp sContext;
    private OrmLiteSqliteOpenHelper mDaoHelper;

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

    public OrmLiteSqliteOpenHelper getDaoHelper(){
        return mDaoHelper;
    }
}
