package com.example.jerry.module_outsale.activity.component;

import com.example.jerry.module_outsale.activity.module.MainActivityModule;
import com.example.jerry.module_outsale.activity.mvp.MainViewActivity;

import dagger.Component;

/**
 * Created by jerry on 2018/7/14.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainViewActivity mainViewActivity);
}
