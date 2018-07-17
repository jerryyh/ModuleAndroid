package com.example.jerry.module_basic.di.module;


import com.example.jerry.module_basic.base.BaseApplication;
import com.example.jerry.module_basic.net.DataHelper;
import com.example.jerry.module_basic.net.HttpHelper;
import com.example.jerry.module_basic.net.HttpHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Module
public class AppModule {

    private final BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    BaseApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }


    @Provides
    @Singleton
    DataHelper provideDataManager(HttpHelper httpHelper) {
        return new DataHelper(httpHelper);
    }

}
