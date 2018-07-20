package com.example.jerry.module_outsale.activity.mvp.home;

import com.example.jerry.module_basic.di.component.AppComponent;
import com.example.jerry.module_outsale.activity.PerFragment;


import dagger.Component;

/**
 * Created by jerry on 2018/7/20.
 */

@PerFragment
@Component(modules = HomeFragmentModule.class, dependencies = AppComponent.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
