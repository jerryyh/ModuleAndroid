package com.example.jerry.module_outsale.activity.mvp.user;

import com.example.jerry.module_basic.base.mvp.BasePresenter;

/**
 * Created by jerry on 2018/7/20.
 */
public class UserMvpPresenter extends BasePresenter<UserMvpContract.View,UserMvpContract.Model> implements UserMvpContract.Presenter{

    @Override
    protected UserMvpContract.Model createModel() {
        return null;
    }

    @Override
    public void attachView(UserMvpContract.View view) {
        super.attachView(view);
    }
}
