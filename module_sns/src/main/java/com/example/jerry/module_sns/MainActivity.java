package com.example.jerry.module_sns;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.jerry.module_basic.observer.ActivityObservable;
import com.example.jerry.module_basic.observer.Observer;
import com.example.jerry.module_basic.util.ToastUtils;
import com.example.jerry.module_sns.arouter.RouterCenter;

/**
 * 观察者对象
 */
public class MainActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sns_activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button bt_test  = findViewById(R.id.bt_test);
        Button bt_test2 = findViewById(R.id.bt_test2);
        Button bt_test3 = findViewById(R.id.bt_test3);
        Button bt_test4 = findViewById(R.id.bt_test4);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show());
        bt_test.setOnClickListener(view -> { Log.i("tag", "000000");RouterCenter.toMvpTest(); });
        bt_test2.setOnClickListener(view -> { Log.i("tag", "0000002");RouterCenter.toOutSale(); });
        ActivityObservable.getInstance().registerObserver(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void action(int id, Object... objects) {
        if (id == 1) ToastUtils.showShort(this, "99999999");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityObservable.getInstance().unRegisterObserver(this);
    }
}
