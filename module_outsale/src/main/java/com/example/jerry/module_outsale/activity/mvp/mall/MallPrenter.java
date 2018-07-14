package com.example.jerry.module_outsale.activity.mvp.mall;

import com.example.jerry.module_basic.base.mvp.BasePresenter;

/**
 * Created by jerry on 2018/7/14.
 */
public class MallPrenter extends BasePresenter<MallContract.View,MallContract.Model> implements MallContract.Presenter {
    @Override
    protected MallContract.Model createModel() {
        return null;
    }

    @Override
    public void attachView(MallContract.View view) {
        super.attachView(view);
    }


}
