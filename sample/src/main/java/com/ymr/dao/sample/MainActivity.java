package com.ymr.dao.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.ymr.dao.Utils;
import com.ymr.dao.sample.db2.MyDaoHelper;
import com.ymr.dao.sample.db2.Test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDbFile();
        /*try {
            Test data = new Test();
            data.setUsername("jjjjjjj");
            data.setPassword("2222222");
            data.create();

            List<Test> tests = Utils.getDaoByClass(Test.class).queryForAll();
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
        }*/

        List<Test> tests = null;
        try {
            tests = Utils.getDaoByClass(Test.class, MyDaoHelper.getInstance(this)).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Test test : tests) {
            Log.i(TAG,"test = " + test);
        }

    }

    private void initDbFile() {
        try {
            FileUtils.copyInputStreamToFile(getAssets().open("my_db.db"),new File(getFilesDir()+"/"+"my_db.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
