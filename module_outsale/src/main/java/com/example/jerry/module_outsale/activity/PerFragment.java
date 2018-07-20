package com.example.jerry.module_outsale.activity;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by admin on 2017/3/12.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerFragment {
}
