package com.example.jerry.module_outsale.activity.mvp.home;

import com.example.jerry.comment_data.bean.BannerData;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.bean.bean.BaseObj;
import com.example.jerry.module_basic.base.mvp.BaseMvpObserver;
import com.example.jerry.module_basic.base.mvp.BasePresenter;
import com.example.jerry.module_basic.net.DataHelper;
import com.example.jerry.module_basic.util.L;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jerry on 2018/7/20.
 */
public class HomeMvpPresenter extends BasePresenter<HomeMvpContract.View, HomeMvpContract.Model> implements HomeMvpContract.Presenter {

    DataHelper dataHelper;
    private boolean mIsRefresh;

    @Inject
    public HomeMvpPresenter(DataHelper dataHelper) {
        this.dataHelper = dataHelper;
    }

    @Override
    protected HomeMvpContract.Model createModel() {
        return new HomeMvpModel();
    }

    @Override
    public void attachView(HomeMvpContract.View view) {
        super.attachView(view);
    }

    @Override
    public void getBannerData(SmartRefreshLayout rlRefreshLayout) {
        addDisposable(
                dataHelper.getBannerData()
                        .subscribeOn(Schedulers.io()) //指定网络请求在IO线程
                        .subscribeOn(AndroidSchedulers.mainThread())//显示进度条在主线程
                        .observeOn(AndroidSchedulers.mainThread())     //显示数据在主线程
                        .subscribeWith(new BaseMvpObserver<BaseObj<List<BannerData>>>() {
                            @Override
                            public void onNext(BaseObj<List<BannerData>> bannerResponse) {
                                mView.showBannerData(bannerResponse.getData());
                            }
                        }));
    }

    @Override
    public void FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page) {
        mIsRefresh = isRefresh;
        addDisposable(dataHelper.getFeedArticleList(page)
                .subscribeOn(Schedulers.io()) //指定网络请求在IO线程
                .subscribeOn(AndroidSchedulers.mainThread())//显示进度条在主线程
                .observeOn(AndroidSchedulers.mainThread())     //显示数据在主线程
                .subscribeWith(new BaseMvpObserver<BaseObj<FeedArticleListData>>(rlRefreshLayout) {
                    @Override
                    public void onNext(BaseObj<FeedArticleListData> listBaseObj) {
                        FeedArticleListData data = listBaseObj.getData();
                        showArticleList(data);
                    }
                }));
    }

    private void showArticleList(FeedArticleListData feedArticleListData) {
        if (feedArticleListData == null) {
            return;
        }
        L.d("显示数据", mIsRefresh + ",showArticleList" + feedArticleListData.getDatas().get(0).getTitle());
        mView.showArticleList(feedArticleListData, mIsRefresh);
    }
}
