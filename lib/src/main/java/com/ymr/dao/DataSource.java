package com.ymr.dao;

import java.util.List;

/**
 * Created by ymr on 15/4/17.
 */
public interface DataSource {
    List<Class<? extends AbsBean>> getDataClasses();
}
