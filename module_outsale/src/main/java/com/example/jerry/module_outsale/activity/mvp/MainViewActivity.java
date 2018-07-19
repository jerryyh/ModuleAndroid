package com.example.jerry.module_outsale.activity.mvp;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jerry.comment_data.bean.FeedArticleData;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.d_arouter.RouterURLS;
import com.example.jerry.module_basic.base.mvp.BaseMvpListActivity;
import com.example.jerry.module_basic.di.component.GlobalAppComponent;
import com.example.jerry.module_basic.observer.ActivityObservable;
import com.example.jerry.module_basic.util.L;
import com.example.jerry.module_outsale.R;
import com.example.jerry.module_outsale.R2;
import com.example.jerry.module_outsale.activity.component.DaggerMainActivityComponent2;
import com.example.jerry.module_outsale.activity.module.MainActivityModule2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jerry on 2018/7/6.
 */
@Route(path = RouterURLS.MALL_MVP_ACTIVITY)
public class MainViewActivity extends BaseMvpListActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {
    private List<FeedArticleData> mFeedArticleDataList;
    private MainListAdapter mAdapter;
    private boolean mIsRefresh;
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R2.id.srl_layout)
    SmartRefreshLayout srlLayout;
    @BindView(R2.id.button)
    Button button;
    @Inject
    MainPrenter presenter;


    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mall_main_view_activity;
    }

    @Override
    protected void initView() {
        super.rlRefreshLayout = srlLayout;
        super.initView();
        initRecyclerView();
    }

    @Override
    public void loadListData(SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        mPresenter.FeedArticleList(isRefresh, rlRefreshLayout, page);
    }

    @Override
    public MainContract.Presenter createPresenter() {
        DaggerMainActivityComponent2.builder()
                .appComponent(GlobalAppComponent.getAppComponent())
                .mainActivityModule2(new MainActivityModule2())
                .build().inject(this);
        ;
        return presenter;
    }

    @Override
    public MainContract.View createView() {
        return this;
    }


    @Override
    public void showTestData(String feedArticleListData) {

    }

    @Override
    public void showArticleList(FeedArticleListData feedArticleListData, boolean mIsRefresh) {
        if (mIsRefresh) {
            mFeedArticleDataList = feedArticleListData.getDatas();
            mAdapter.replaceData(mFeedArticleDataList);
        } else {
            mFeedArticleDataList.addAll(feedArticleListData.getDatas());
            mAdapter.addData(feedArticleListData.getDatas());
        }
    }

    @OnClick(R2.id.button)
    public void onClick() {
        mPresenter.getPopuPageResult();
        //提醒观察者更新
        ActivityObservable.getInstance().notifyObservers(1, "99999999");
    }

    private void initRecyclerView() {
        mFeedArticleDataList = new ArrayList<>();
        mAdapter = new MainListAdapter(mFeedArticleDataList);
        mAdapter.openLoadAnimation();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                L.d("点击了条目");
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                L.d("点击了子条目");
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }
}
