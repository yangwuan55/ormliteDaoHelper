package com.ymr.daofactory;


import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/17.
 */
public abstract class OrmModelFactory<T> {

    protected static OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper;
    protected Dao<T, Integer> dao;

    protected OrmModelFactory(OrmLiteSqliteOpenHelper helper, Class<T> ormEntity) throws SQLException {
        ormLiteSqliteOpenHelper = helper;
        this.dao = ormLiteSqliteOpenHelper.getDao(ormEntity);
    }

    public Dao<T, Integer> getDao() {
        return this.dao;
    }
}
