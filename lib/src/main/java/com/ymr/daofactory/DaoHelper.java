package com.ymr.daofactory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.IllegalFormatCodePointException;
import java.util.Objects;

/**
 * Created by ymr on 15/4/17.
 */
public abstract class DaoHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = "DaoHelper";
    private final DataSource mDataSource;

    public DaoHelper(Context context,String dateBaseName,int datebseVersion) {
        super(context, dateBaseName, null, datebseVersion);
        mDataSource = getDataSource();
    }

    //工厂方法模式：）
    protected abstract DataSource getDataSource();

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        initTables(connectionSource);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        initTables(connectionSource);
    }

    private void initTables(ConnectionSource connectionSource) {
        if (mDataSource != null && mDataSource.getDataClasses() != null && mDataSource.getDataClasses().size() > 0) {
            for (Class aClass : mDataSource.getDataClasses()) {
                try {
                    TableUtils.createTable(connectionSource, aClass);
                } catch (SQLException e) {
                    Log.e(TAG, "DaoHelper:" + e.toString());
                }
            }
        } else {
            throw new RuntimeException("must get the DataSoure at child class");
        }
    }

}
