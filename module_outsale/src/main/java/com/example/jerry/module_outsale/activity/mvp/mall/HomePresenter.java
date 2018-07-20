package com.example.jerry.module_outsale.activity.mvp.mall;

import com.example.jerry.module_basic.base.mvp.BasePresenter;

/**
 * Created by jerry on 2018/7/14.
 */
public class HomePresenter extends BasePresenter<HomeContract.View,HomeContract.Model> implements HomeContract.Presenter {



    @Override
    protected HomeContract.Model createModel() {
        return null;
    }

    @Override
    public void attachView(HomeContract.View view) {
        super.attachView(view);
    }


}
