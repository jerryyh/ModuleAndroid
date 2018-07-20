package com.example.jerry.module_outsale.activity.mvp.user;

import android.os.Bundle;

import com.example.jerry.module_basic.base.mvp.BaseMvpFragment;
import com.example.jerry.module_outsale.R;
import com.example.jerry.module_outsale.activity.mvp.mall.HomeContract;

/**
 * Created by jerry on 2018/7/20.
 */
public class UserFragment extends BaseMvpFragment<UserMvpContract.View,UserMvpContract.Presenter> implements HomeContract.View {

    public static UserFragment newInstance(String info) {
        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.mall_fragment_user;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public UserMvpContract.Presenter createPresenter() {
        return new UserMvpPresenter();
    }

    @Override
    public UserMvpContract.View createView() {
        return null;
    }
}
