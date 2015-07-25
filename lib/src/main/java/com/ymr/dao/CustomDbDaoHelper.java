package com.ymr.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

/**
 * Created by ymr on 15/7/25.
 */
public abstract class CustomDbDaoHelper extends DaoHelper {

    public CustomDbDaoHelper(Context context, String dateBaseName, int datebseVersion) {
        super(context, dateBaseName, datebseVersion);
    }

    @Override
    protected DataSource getDataSource() {
        return null;
    }

    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {
        return SQLiteDatabase.openDatabase(getDatabasePath(), null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        return SQLiteDatabase.openDatabase(getDatabasePath(), null,
                SQLiteDatabase.OPEN_READONLY);
    }

    protected abstract String getDatabasePath();
}
