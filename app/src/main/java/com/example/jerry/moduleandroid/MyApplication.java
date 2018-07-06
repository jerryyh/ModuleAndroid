package com.example.jerry.moduleandroid;

import com.example.jerry.module_basic.base.BaseApplication;

/**
 * Created by jerry on 2018/7/5.
 */
public class MyApplication extends BaseApplication {
    private static MyApplication myApplication;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
}
