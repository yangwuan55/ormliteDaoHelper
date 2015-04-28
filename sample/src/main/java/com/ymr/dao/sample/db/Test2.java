package com.ymr.dao.sample.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.ymr.dao.AbsBean;
import com.ymr.dao.sample.App;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/17.
 */
@DatabaseTable
public class Test2 extends AbsBean<Test2>{

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String aaa;
    @DatabaseField
    private String bbb;

    public Test2() throws SQLException {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "id=" + id +
                ", aaa='" + aaa + '\'' +
                ", bbb='" + bbb + '\'' +
                '}';
    }
}
