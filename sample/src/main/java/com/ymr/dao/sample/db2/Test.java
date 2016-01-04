package com.ymr.dao.sample.db2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.ymr.dao.AbsBean;
import com.ymr.dao.sample.App;

import java.sql.SQLException;

/**
 * Created by ymr on 15/4/17.
 */
@DatabaseTable
public class Test extends AbsBean<Test,Integer>{
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String username;
    @DatabaseField
    private String password;
    @DatabaseField
    private String haha;

    public Test() throws SQLException {
        super(MyDaoHelper.getInstance(App.getApp()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHaha() {
        return haha;
    }

    public void setHaha(String haha) {
        this.haha = haha;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", haha='" + haha + '\'' +
                '}';
    }
}
