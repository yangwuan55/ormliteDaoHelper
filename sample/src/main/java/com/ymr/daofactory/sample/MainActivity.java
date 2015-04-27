package com.ymr.daofactory.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ymr.daofactory.R;
import com.ymr.daofactory.sample.db.Test;
import com.ymr.daofactory.sample.db.Test2;

import java.sql.SQLException;
import java.util.List;


public class MainActivity extends ActionBarActivity {

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
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
