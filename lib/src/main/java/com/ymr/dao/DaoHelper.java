package com.ymr.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

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

    protected abstract DataSource getDataSource();

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        initTables(connectionSource);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        initTables(connectionSource);
    }

    protected void initTables(ConnectionSource connectionSource) {
        if (mDataSource != null && mDataSource.getDataClasses() != null && mDataSource.getDataClasses().size() > 0) {
            checkClasses();
            for (Class aClass : mDataSource.getDataClasses()) {
                try {
                    TableUtils.dropTable(connectionSource,aClass,true);
                    TableUtils.createTable(connectionSource, aClass);
                } catch (SQLException e) {
                    Log.e(TAG, "DaoHelper:" + e.toString());
                }
            }
        } else {
            throw new RuntimeException("must get the DataSoure at child class");
        }
    }

    private void checkClasses() {
        for (Class aClass : mDataSource.getDataClasses()) {
            if (!AbsBean.class.isAssignableFrom(aClass)) {
                throw new RuntimeException(aClass.getName()+" is not AbsBean's child class.");
            }
        }
    }

}
