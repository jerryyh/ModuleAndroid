package com.example.jerry.module_outsale.activity.module;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.example.jerry.module_outsale.activity.mvp.MainPrenter;
import com.example.jerry.module_outsale.activity.mvp.MainViewActivity;


import dagger.Module;
import dagger.Provides;

/**
 * Created by jerry on 2018/7/14.
 */
@Module
public class MainActivityModule {
    MainViewActivity activity;
    RecyclerView recyclerView;

    public MainActivityModule(MainViewActivity activity, RecyclerView recyclerView) {
        this.activity = activity;
        this.recyclerView = recyclerView;
    }

    @Provides
    public Activity provideActivity() {
        return activity;
    }

    @Provides
    public RecyclerView provideRecyclerView() {
        return recyclerView;
    }

    @Provides
    public MainPrenter provideMainPrenter() {
        return new MainPrenter(activity, recyclerView);
    }
}
