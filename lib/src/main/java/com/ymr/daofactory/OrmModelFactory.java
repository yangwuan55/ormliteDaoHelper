package com.ymr.daofactory;


import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/17.
 */
public abstract class OrmModelFactory<T> {

    protected static OrmLiteSqliteOpenHelper mOrmLiteSqliteOpenHelper;
    protected Dao<T, Integer> mDao;

    protected OrmModelFactory(OrmLiteSqliteOpenHelper helper, Class<T> ormEntity) throws SQLException {
        mOrmLiteSqliteOpenHelper = helper;
        this.mDao = mOrmLiteSqliteOpenHelper.getDao(ormEntity);
    }

    public Dao<T, Integer> getDao() {
        return this.mDao;
    }
}
