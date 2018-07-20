package com.example.jerry.module_outsale.activity.module;

import com.example.jerry.module_basic.net.DataHelper;
import com.example.jerry.module_outsale.activity.mvp.MainPrenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jerry on 2018/7/14.
 */
@Module
public class MainActivityModule2 {

    @Provides
    public MainPrenter provideMainPrenter(DataHelper dataHelper) {
        return new MainPrenter(dataHelper);
    }

}
