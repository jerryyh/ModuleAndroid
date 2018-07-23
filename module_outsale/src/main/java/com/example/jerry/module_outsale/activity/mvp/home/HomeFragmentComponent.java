package com.example.jerry.module_outsale.activity.mvp.home;

import com.example.jerry.module_basic.di.component.AppComponent;
import com.example.jerry.module_outsale.activity.PerFragment;


import dagger.Component;

/**
 * Created by jerry on 2018/7/20.
 */

@PerFragment
            //Component从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分。将Module中产生的依赖对象自动注入到需要依赖实例的Container中。
            //一个Component可以添加多个Module，这样Component获取依赖时候会自动从多个Module中查找获取。添加多个Module有两种方法，一种是在Component的注解@Component(modules={××××，×××})中添加多个modules
            //另外一种添加多个Module的方法可以使用@Module的 includes的方法（includes={××××，×××}）
@Component(modules = HomeFragmentModule.class, dependencies = AppComponent.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
