package com.example.jerry.module_outsale.activity;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by admin on 2017/3/12.
 */
@Scope  //注明是Scope
@Documented //标记文档提示
@Retention(RUNTIME)  //运行时级别    对于Android，我们通常会定义一个针对整个APP全生命周期的@PerApp的Scope注解和针对一个Activity生命周期的@PerActivity注解
public @interface PerActivity {
}
