package com.example.jerry.module_outsale.activity.mvp.home;

import com.example.jerry.module_basic.net.DataHelper;
import com.example.jerry.module_outsale.activity.PerFragment;
import com.example.jerry.module_outsale.activity.mvp.MainPrenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jerry on 2018/7/20.
 */
//依赖注入是用来给应用的各部分解耦的。使应用开发更加可扩展，更容易维护
@Module
public class HomeFragmentModule {
//    @Provides
//    public HomeMvpPresenter provideHomeMvpPresenter(DataHelper dataHelper) {//如果找不到被@Provides注释的方法提供对应参数对象的话，将会自动调用被@Inject注释的构造方法生成相应对象
//        return  new HomeMvpPresenter(dataHelper);
//    }
}
