package com.example.jerry.module_basic.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jerry.module_basic.base.mvp.inter.IPresenter;
import com.example.jerry.module_basic.base.mvp.inter.IView;
import com.example.jerry.module_basic.base.mvp.inter.MvpCallback;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jerry on 2018/7/6.
 */
public abstract class BaseMvpActivity<V extends IView, P extends IPresenter<V>> extends AppCompatActivity implements MvpCallback<V, P>, IView {
    protected V mView;
    protected P mPresenter;
    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        onViewCreated();
        initTitle();
        initView();
    }
    /**
     * 初始化标题
     */
    protected abstract void initTitle();

    protected abstract int getLayoutId();

    protected abstract void initView();

    /**
     * 初始化presenter
     */
    public void onViewCreated() {
        mView = createView();
        if (getPresenter() == null) {
            mPresenter = createPresenter();
            getLifecycle().addObserver(mPresenter);
        }
        mPresenter = getPresenter();
        mPresenter.attachView(getMvpView());
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showError(String msg, String code) {

    }

    @Override
    public void showHUD(String msg) {

    }

    @Override
    public void dismissHUD() {

    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
        setPresenter(null);
        setMvpView(null);
    }


    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void setMvpView(V view) {
        this.mView = view;
    }

    @Override
    public V getMvpView() {
        return mView;
    }
}
