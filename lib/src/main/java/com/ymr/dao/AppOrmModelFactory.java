package com.ymr.dao;

import com.j256.ormlite.dao.Dao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by ymr on 15/4/27.
 */
public abstract class AppOrmModelFactory<T,ID>{
    private static DaoHelper sOrmLiteSqliteOpenHelper;
    private static HashMap<Class,Dao> sDaos = new HashMap<>();
    private final Class<T> mEntityClass;

    protected AppOrmModelFactory(DaoHelper daoHelper) {
        mEntityClass =(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        sOrmLiteSqliteOpenHelper = daoHelper;
        if (mEntityClass == null) {
            throw new RuntimeException("There hasnt a T.");
        }
    }

    public Dao<T, ID> getDao() throws SQLException {
        Dao<T, ID> dao = sDaos.get(mEntityClass);
        if (dao == null) {
            dao = sOrmLiteSqliteOpenHelper.getDao(mEntityClass);
            sDaos.put(mEntityClass,dao);
        }
        return dao;
    }

    static <T,ID> Dao<T,ID> getDaoByClass(Class<T> c,DaoHelper daoHelper) throws SQLException {
        Dao<T, ID> dao = sDaos.get(c);
        if (dao == null) {
            dao = daoHelper.getDao(c);
            sDaos.put(c,dao);
        }
        return dao;
    }
}
