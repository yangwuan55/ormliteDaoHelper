package com.ymr.dao.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.ymr.dao.sample.db.Test;
import com.ymr.dao.sample.db.Test2;

import java.sql.SQLException;
import java.util.List;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Test data = new Test();
            data.setUsername("jjjjjjj");
            data.setPassword("2222222");
            data.create();

            List<Test> tests = data.getDao().queryForAll();
            for (Test test : tests) {
                Log.i(TAG,"test = " + test);
            }
        } catch (SQLException e) {
            Log.e(TAG,"E:" + e.toString());
        }

        try {
            Test2 test2 = new Test2();
            test2.setAaa("2222");
            test2.setBbb("4444");
            test2.create();

            List<Test2> test2s = test2.getDao().queryForAll();
            for (Test2 test21 : test2s) {
                Log.i(TAG,"test21 = " + test21);
            }

        } catch (SQLException e) {
            Log.e(TAG,"E:" + e.toString());
        }

    }
}
