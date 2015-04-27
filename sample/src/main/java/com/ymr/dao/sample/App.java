package com.ymr.dao.sample;

import com.ymr.dao.AbstractApp;
import com.ymr.dao.DaoHelper;
import com.ymr.dao.sample.db.MyDaoHelper;

/**
 * Created by ymr on 15/4/17.
 */
public class App extends AbstractApp {
    @Override
    protected DaoHelper getSubDaoHelper() {
        return MyDaoHelper.getInstance(this);
    }
}
