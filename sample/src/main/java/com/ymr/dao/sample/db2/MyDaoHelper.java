package com.ymr.dao.sample.db2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.support.ConnectionSource;
import com.ymr.dao.CustomDbDaoHelper;
import com.ymr.dao.DaoHelper;
import com.ymr.dao.sample.App;

/**
 * Created by ymr on 15/4/17.
 */
public class MyDaoHelper extends CustomDbDaoHelper {

    public static final String DATE_BASE_NAME = "my_db.db";
    public static final int DATEBSE_VERSION = 5;

    private static DaoHelper sInstance;

    private MyDaoHelper(Context context) {
        super(context, DATE_BASE_NAME, DATEBSE_VERSION);
    }

    public static DaoHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MyDaoHelper(context);
        }
        return sInstance;
    }

    @Override
    protected String getDatabasePath() {
        return App.getContext().getFilesDir()+"/"+"my_db.db";
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
