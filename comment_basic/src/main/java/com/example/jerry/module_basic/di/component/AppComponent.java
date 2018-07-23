package com.example.jerry.module_basic.di.component;


import com.example.jerry.module_basic.base.BaseApplication;
import com.example.jerry.module_basic.di.module.AppModule;
import com.example.jerry.module_basic.di.module.HttpModule;
import com.example.jerry.module_basic.net.DataHelper;

import javax.inject.Singleton;

import dagger.Component;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Singleton // 标明该Component中有Module使用了@Singleton
@Component(
        modules = {
                AppModule.class,
                HttpModule.class}
)
public interface AppComponent {

    /**
     * 注入WanAndroidApp实例
     *
     * @param baseApplication BaseApplication
     */
    void inject(BaseApplication baseApplication);

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    BaseApplication getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataHelper getDataHelper();

}
