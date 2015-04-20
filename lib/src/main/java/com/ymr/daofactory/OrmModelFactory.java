package com.ymr.daofactory;


import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/17.
 */
public abstract class OrmModelFactory<T> {

    protected static DaoHelper mOrmLiteSqliteOpenHelper;
    protected Dao<T, Integer> mDao;

    protected OrmModelFactory(DaoHelper helper, Class<T> ormEntity) throws SQLException {
        mOrmLiteSqliteOpenHelper = helper;
        if (helper.getDataSource().getDataClasses().contains(ormEntity)) {
            this.mDao = mOrmLiteSqliteOpenHelper.getDao(ormEntity);
        } else {
            throw new RuntimeException("the Class:" + ormEntity.getName() + " isnt contained at DataSource");
        }
    }

    public Dao<T, Integer> getDao() {
        return this.mDao;
    }
}
