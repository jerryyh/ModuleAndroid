package com.example.jerry.module_outsale.activity.mvp.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jerry.comment_data.bean.BannerData;
import com.example.jerry.comment_data.bean.FeedArticleData;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.module_basic.base.mvp.BaseMvpListFragment;
import com.example.jerry.module_basic.di.component.GlobalAppComponent;
import com.example.jerry.module_basic.util.GlideImageLoader;
import com.example.jerry.module_basic.util.L;
import com.example.jerry.module_outsale.R;
import com.example.jerry.module_outsale.R2;
import com.example.jerry.module_outsale.activity.mvp.MainListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.header.TwoLevelHeader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by jerry on 2018/7/20.
 */
public class HomeFragment extends BaseMvpListFragment<HomeMvpContract.View, HomeMvpContract.Presenter> implements HomeMvpContract.View {
    @BindView(R2.id.main_pager_recycler_view)
    RecyclerView recyclerView;
    @BindView(R2.id.normal_view)
    SmartRefreshLayout normalView;
    @BindView(R2.id.secondfloor)
    ImageView secondfloor;
    @BindView(R2.id.secondfloor_content)
    ImageView secondfloorContent;
    @BindView(R2.id.classics)
    ClassicsHeader classics;
    @BindView(R2.id.header)
    TwoLevelHeader header;
    private List<FeedArticleData> mFeedArticleDataList;
    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;
    private MainListAdapter mAdapter;
    private Banner mBanner;
    @Inject
    HomeMvpPresenter presenter;//引入HomeMvpPresenter对象

    public static HomeFragment newInstance(String info) {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.mall_fragment_home;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {
        super.rlRefreshLayout = normalView;
        super.initView();
        initRefresh();
        initRecyclerView();
        mPresenter.getBannerData(normalView);
    }

    private void initRefresh() {
        header.setOnTwoLevelListener(refreshLayout -> {
            Toast.makeText(getContext(), "触发二楼事件", Toast.LENGTH_SHORT).show();
            secondfloorContent.animate().alpha(1).setDuration(2000);
            refreshLayout.getLayout().postDelayed(()->{ header.finishTwoLevel();secondfloorContent.animate().alpha(0).setDuration(1000); }, 5000);
            return true;//true 将会展开二楼状态 false 关闭刷新
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mBanner != null) {
            mBanner.stopAutoPlay();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public HomeMvpContract.Presenter createPresenter() {
        DaggerHomeFragmentComponent.builder()
                .appComponent(GlobalAppComponent.getAppComponent())
                .homeFragmentModule(new HomeFragmentModule())
                .build().inject(this);
        return presenter;
    }

    @Override
    public HomeMvpContract.View createView() {
        return this;
    }

    @Override
    public void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        mPresenter.FeedArticleList(isRefresh, rlRefreshLayout, page);
    }

    private void initRecyclerView() {
        mFeedArticleDataList = new ArrayList<>();
        mAdapter = new MainListAdapter(mFeedArticleDataList);
        mAdapter.openLoadAnimation();
        mAdapter.setOnItemClickListener((adapter, view, position) -> L.d("点击了条目"));
        mAdapter.setOnItemChildClickListener((adapter, view, position) -> L.d("点击了子条目"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayout mHeaderGroup = ((LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.mall_head_banner, null));
        mBanner = mHeaderGroup.findViewById(R.id.head_banner);
        mHeaderGroup.removeView(mBanner);
        mAdapter.addHeaderView(mBanner);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showBannerData(List<BannerData> bannerDataList) {
        mBannerTitleList = new ArrayList<>();
        List<String> bannerImageList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        for (BannerData bannerData : bannerDataList) {
            mBannerTitleList.add(bannerData.getTitle());
            bannerImageList.add(bannerData.getImagePath());
            mBannerUrlList.add(bannerData.getUrl());
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(bannerImageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(mBannerTitleList);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(bannerDataList.size() * 400);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
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
}
