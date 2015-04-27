package com.ymr.daofactory;

import com.j256.ormlite.dao.Dao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ymr on 15/4/27.
 */
public abstract class AppOrmModelFactory<T>{


    protected static DaoHelper sOrmLiteSqliteOpenHelper;
    protected static HashMap<Class,Dao> sDaos = new HashMap<>();
    private final Class<T> mEntityClass;

    protected AppOrmModelFactory(AbstractApp app) throws SQLException {
        sOrmLiteSqliteOpenHelper = app.getDaoHelper();
        mEntityClass =(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (mEntityClass == null) {
            throw new RuntimeException("There hasnt a T.");
        }
    }

    public Dao<T, Integer> getDao() throws SQLException {
        Dao<T, Integer> dao = sDaos.get(mEntityClass);
        if (dao == null) {
            dao = sOrmLiteSqliteOpenHelper.getDao(mEntityClass);
            sDaos.put(mEntityClass,dao);
        }
        return dao;
    }

}
