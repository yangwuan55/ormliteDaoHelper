package com.ymr.daofactory.test.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.ymr.daofactory.OrmModelFactory;
import com.ymr.daofactory.test.App;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/17.
 */
public class TestDaoHelper extends OrmModelFactory<Test> {
    private static Dao<Test,Integer> sDao;
    private static TestDaoHelper helper;
    private TestDaoHelper(Class<Test> ormEntity) throws SQLException {
        super(App.getContext().getDaoHelper(), ormEntity);
    }

    public static TestDaoHelper getInstance() throws SQLException {
        if (helper == null) {
            helper = new TestDaoHelper(Test.class);
        }
        return helper;
    }
}
