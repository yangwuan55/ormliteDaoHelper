package com.ymr.dao;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/27.
 */
public abstract class AbsBean<T extends AbsBean,ID> extends AppOrmModelFactory<T,ID> {

    protected AbsBean() throws SQLException {
        super(AbstractApp.getContext());
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
