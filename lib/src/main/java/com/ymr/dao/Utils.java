package com.ymr.dao;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/28.
 */
public class Utils {

    public static <T,ID> Dao<T,ID> getDaoByClass(Class<T> c,DaoHelper daoHelper) throws SQLException {
        return AppOrmModelFactory.getDaoByClass(c,daoHelper);
    }
}
