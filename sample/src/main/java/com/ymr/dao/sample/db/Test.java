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
public class Test extends AbsBean<Test>{
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String username;
    @DatabaseField
    private String password;

    public Test() throws SQLException {
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

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
