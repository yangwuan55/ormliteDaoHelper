package com.ymr.daofactory.sample;

import com.ymr.daofactory.AbstractApp;
import com.ymr.daofactory.DaoHelper;
import com.ymr.daofactory.sample.db.MyDaoHelper;

/**
 * Created by ymr on 15/4/17.
 */
public class App extends AbstractApp {
    @Override
    protected DaoHelper getSubDaoHelper() {
        return MyDaoHelper.getInstance(this);
    }
}
