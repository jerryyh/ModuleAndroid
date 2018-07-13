package com.example.jerry.module_outsale.activity.mvp;


import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.jerry.comment_data.d_arouter.RouterURLS;
import com.example.jerry.module_basic.base.mvp.BaseMvpListActivity;
import com.example.jerry.module_outsale.R;
import com.example.jerry.module_outsale.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jerry on 2018/7/6.
 */
@Route(path = RouterURLS.MALL_MVP_ACTIVITY)
public class MainViewActivity extends BaseMvpListActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {

    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R2.id.srl_layout)
    SmartRefreshLayout srlLayout;
    @BindView(R2.id.button)
    Button button;

    @Override
    protected int getLayout() {
        return R.layout.mall_main_view_activity;
    }

    @Override
    protected void initView() {
        super.rlRefreshLayout = srlLayout;
        super.initView();
    }

    @Override
    public void loadListData(SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        mPresenter.FeedArticleList(isRefresh, rlRefreshLayout, page);
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPrenter(this, recyclerView);
    }

    @Override
    public MainContract.View createView() {
        return this;
    }


    @Override
    public void showTestData(String feedArticleListData) {

    }

    @OnClick(R2.id.button)
    public void onClick() {
        mPresenter.getPopuPageResult();
    }
}
