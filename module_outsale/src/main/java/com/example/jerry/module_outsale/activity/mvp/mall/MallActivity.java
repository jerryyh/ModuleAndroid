package com.example.jerry.module_outsale.activity.mvp.mall;

import android.support.v7.widget.RecyclerView;

import com.example.jerry.module_basic.base.mvp.BaseMvpListActivity;
import com.example.jerry.module_outsale.R;
import com.example.jerry.module_outsale.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

/**
 * Created by jerry on 2018/7/14.
 */
public class MallActivity extends BaseMvpListActivity<MallContract.View, MallContract.Presenter> implements MallContract.View {
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R2.id.srl_layout)
    SmartRefreshLayout srlLayout;

    @Override
    public void loadListData(SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mall_list_activity;
    }

    @Override
    public MallContract.Presenter createPresenter() {
        return null;
    }

    @Override
    public MallContract.View createView() {
        return this;
    }
}
