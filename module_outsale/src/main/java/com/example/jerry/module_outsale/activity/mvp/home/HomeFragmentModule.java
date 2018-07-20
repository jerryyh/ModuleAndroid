package com.example.jerry.module_outsale.activity.mvp.home;

import com.example.jerry.module_basic.net.DataHelper;
import com.example.jerry.module_outsale.activity.PerFragment;
import com.example.jerry.module_outsale.activity.mvp.MainPrenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jerry on 2018/7/20.
 */

@Module
public class HomeFragmentModule {
    @Provides
    public HomeMvpPresenter provideHomeMvpPresenter(DataHelper dataHelper) {
        return  new HomeMvpPresenter(dataHelper);
    }
}
