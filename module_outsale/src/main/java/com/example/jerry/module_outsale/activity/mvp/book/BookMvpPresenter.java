package com.example.jerry.module_outsale.activity.mvp.book;

import com.example.jerry.module_basic.base.mvp.BasePresenter;

/**
 * Created by jerry on 2018/7/20.
 */
public class BookMvpPresenter extends BasePresenter<BookMvpContract.View,BookMvpContract.Model> implements BookMvpContract.Presenter{

    @Override
    protected BookMvpContract.Model createModel() {
        return null;
    }

    @Override
    public void attachView(BookMvpContract.View view) {
        super.attachView(view);
    }
}
