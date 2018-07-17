package com.example.jerry.module_basic.di.component;

import android.app.Application;
import android.content.Context;

import com.example.jerry.module_basic.base.BaseApplication;
import com.example.jerry.module_basic.di.module.AppModule;

/**
 * @author：admin on 2017/4/15 15:26.
 *
 */

public class GlobalAppComponent {
    private volatile static AppComponent mAppComponent;

    /**
     * 初始化全局AppComponent
     * @param context applicationContext
     */
    public static void init(Application context){
        if(mAppComponent == null){
            synchronized (GlobalAppComponent.class){
                if(mAppComponent == null){
                    mAppComponent = DaggerAppComponent.builder()
                            .appModule(new AppModule((BaseApplication) context))
                            .build();
                }
            }
        }
    }

    public static AppComponent getAppComponent() {
        if(mAppComponent == null){
            throw (new NullPointerException("GlobalAppComponent必须在application中进行init初始化"));
        }
        return mAppComponent;
    }
}
