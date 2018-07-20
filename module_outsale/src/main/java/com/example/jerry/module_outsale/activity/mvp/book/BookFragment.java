package com.example.jerry.module_outsale.activity.mvp.book;

import android.os.Bundle;

import com.example.jerry.module_basic.base.mvp.BaseMvpFragment;
import com.example.jerry.module_outsale.R;
import com.example.jerry.module_outsale.activity.mvp.mall.HomeContract;

/**
 * Created by jerry on 2018/7/20.
 */
public class BookFragment extends BaseMvpFragment<BookMvpContract.View,BookMvpContract.Presenter> implements BookMvpContract.View {

    public static BookFragment newInstance(String info) {
        Bundle args = new Bundle();
        BookFragment fragment = new BookFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.mall_fragment_book;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public BookMvpContract.Presenter createPresenter() {
        return new BookMvpPresenter();
    }

    @Override
    public BookMvpContract.View createView() {
        return this;
    }
}
