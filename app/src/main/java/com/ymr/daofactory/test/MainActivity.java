package com.ymr.daofactory.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.j256.ormlite.dao.Dao;
import com.ymr.daofactory.R;
import com.ymr.daofactory.test.db.Test;
import com.ymr.daofactory.test.db.TestDaoHelper;

import java.sql.SQLException;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";
    private Dao<Test, Integer> mTestDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Dao<Test, Integer> dao = TestDaoHelper.getInstance().getDao();
            Test data = new Test();
            data.setUsername("jjjjjjj");
            data.setPassword("2222222");
            dao.create(data);

            List<Test> tests = dao.queryForAll();
            for (Test test : tests) {
                Log.i(TAG,"test = " + test);
            }
        } catch (SQLException e) {
            Log.e(TAG,"E:" + e.toString());
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
