package com.example.jerry.module_basic.bean;


import com.example.jerry.module_basic.base.mvp.BaseMvpFragment;

/**
 * @Created by TOME .
 * @时间 2018/6/5 15:27
 * @描述 ${}
 */
public class TabListBean {
    private String title;
    private BaseMvpFragment fragment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseMvpFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseMvpFragment fragment) {
        this.fragment = fragment;
    }

    public TabListBean(String title, BaseMvpFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }
}
