package com.example.jerry.module_outsale.activity.mvp;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.module_basic.base.mvp.BaseMvpObserver;
import com.example.jerry.module_basic.base.mvp.BasePresenter;
import com.example.jerry.module_basic.net.params.RequestMapParams;
import com.example.jerry.module_basic.util.L;
import com.example.jerry.module_basic.util.ToastUtils;
import com.example.jerry.module_outsale.activity.bean.FeedArticleData;
import com.example.jerry.module_outsale.activity.bean.FeedArticleListData;
import com.example.jerry.module_outsale.activity.bean.PopupPageResp;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jerry on 2018/7/6.
 */
public class MainPrenter extends BasePresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter {

    private List<FeedArticleData> mFeedArticleDataList;
    private RecyclerView mRecyclerView;
    private MainListAdapter mAdapter;
    private boolean mIsRefresh;
    private Context mActivity;

    public MainPrenter(Context acticity, RecyclerView recyclerView) {
        this.mActivity = acticity;
        mRecyclerView = recyclerView;
        initRecyclerView();
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    protected MainContract.Model createModel() {
        return new MainModel(this);
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return 2;
            }
        });
    }

    private void showArticleList(FeedArticleListData feedArticleListData) {
        if (feedArticleListData == null) {
            return;
        }
        L.d("显示数据", mIsRefresh + ",showArticleList" + feedArticleListData.getDatas().get(0).getTitle());
        if (mIsRefresh) {
            mFeedArticleDataList = feedArticleListData.getDatas();
            mAdapter.replaceData(mFeedArticleDataList);
        } else {
            mFeedArticleDataList.addAll(feedArticleListData.getDatas());
            mAdapter.addData(feedArticleListData.getDatas());
        }
    }

    @Override
    public void FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page) {
        mIsRefresh = isRefresh;
        addDisposable(mModel.getFeedArticleList(page).subscribeOn(Schedulers.io()) //指定网络请求在IO线程
                        //  .retryWhen(new RetryWithDelay)////遇到错误时重试
                        .doOnSubscribe(disposable -> {
                            if (mIsRefresh) {
                                // mView.showLoading();//显示下拉刷新的进度条
                                // mView
                            } else {
                                // mView.startLoadMore();//显示上拉加载更多的进度条
                            }
                        }).subscribeOn(AndroidSchedulers.mainThread())//显示进度条在主线程
                        .observeOn(AndroidSchedulers.mainThread())     //显示数据在主线程
                        .doFinally(() -> {
                            if (mIsRefresh) {
                                // mView.hideLoading();//隐藏下拉刷新的进度条
                            } else {
                                // mView.endLoadMore();//隐藏上拉加载更多的进度条
                            }
                        })
                        // .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                        .subscribeWith(new BaseMvpObserver<BaseObj<FeedArticleListData>>(rlRefreshLayout) {
                            @Override
                            public void onNext(BaseObj<FeedArticleListData> listBaseObj) {
                                FeedArticleListData data = listBaseObj.getData();
                                showArticleList(data);
                            }
                        }));
    }

    @Override
    public void getPopuPageResult() {
        RequestMapParams params = new RequestMapParams();
        addDisposable(mModel.getPopuPageResult(params).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new BaseMvpObserver<BaseObj2<PopupPageResp>>() {
                    @Override
                    public void onNext(BaseObj2<PopupPageResp> popupPageRespBaseObj2) {
                        ToastUtils.showShort(mActivity, "6666666");
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                })
        );
    }
}
