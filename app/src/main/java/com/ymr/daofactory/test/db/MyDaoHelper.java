package com.ymr.daofactory.test.db;

import android.content.Context;

import com.ymr.daofactory.DaoHelper;
import com.ymr.daofactory.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymr on 15/4/17.
 */
public class MyDaoHelper extends DaoHelper {

    public static final String DATE_BASE_NAME = "my_db";
    public static final int DATEBSE_VERSION = 3;

    private static DaoHelper sInstance;

    private MyDaoHelper(Context context) {
        super(context, DATE_BASE_NAME, DATEBSE_VERSION);
    }

    public static DaoHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MyDaoHelper(context);
        }
        return sInstance;
    }

    @Override
    protected DataSource getDataSource() {
        return new DataSource() {
            @Override
            public List<Class> getDataClasses() {
                List<Class> classes = new ArrayList<>();
                classes.add(Test.class);
                return classes;
            }
        };
    }
}