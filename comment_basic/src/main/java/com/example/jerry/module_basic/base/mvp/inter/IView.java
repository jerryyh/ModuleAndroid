package com.example.jerry.module_basic.base.mvp.inter;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

/**
 * 顶级View接口
 * Created by jerry on 2018/7/6.
 */
public interface IView extends LifecycleOwner {

    Context getContext();

    void showError(String msg, String code);

    /**
     * 显示Dialog
     */
    void showHUD(String msg);

    /**
     * 关闭Dialog
     */
    void dismissHUD();
}
