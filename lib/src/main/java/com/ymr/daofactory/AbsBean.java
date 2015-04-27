package com.ymr.daofactory;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/27.
 */
public abstract class AbsBean<T extends AbsBean> extends AppOrmModelFactory<T> {

    protected AbsBean(AbstractApp app) throws SQLException {
        super(app);
    }

    public void create() throws SQLException {
        getDao().create((T) this);
    }

    public void update() throws SQLException {
        getDao().update((T) this);
    }

    public void delete() throws SQLException {
        getDao().delete((T) this);
    }
}