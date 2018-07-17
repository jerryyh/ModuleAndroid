package com.example.jerry.module_outsale.activity.component;



import com.example.jerry.module_basic.di.component.AppComponent;
import com.example.jerry.module_outsale.activity.PerActivity;
import com.example.jerry.module_outsale.activity.module.MainActivityModule2;
import com.example.jerry.module_outsale.activity.mvp.MainViewActivity;

import dagger.Component;

/**
 * Created by jerry on 2018/7/14.
 */

@PerActivity
@Component(modules = MainActivityModule2.class,dependencies = AppComponent.class)
public interface MainActivityComponent2 {
    void inject(MainViewActivity mainViewActivity);
}
