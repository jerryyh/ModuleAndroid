package com.example.jerry.module_outsale.activity.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.bean.PopupPageResp;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.comment_data.constant.BaseHost;
import com.example.jerry.module_basic.base.mvp.BaseMvpObserver;
import com.example.jerry.module_basic.base.mvp.BasePresenter;
import com.example.jerry.module_basic.di.component.GlobalAppComponent;
import com.example.jerry.module_basic.net.DataHelper;
import com.example.jerry.module_basic.net.params.RequestMapParams;
import com.example.jerry.module_basic.util.DeviceUtil;
import com.example.jerry.module_basic.util.L;
import com.example.jerry.module_basic.util.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.jerry.comment_data.constant.HostType.NEWS_DETAIL_HTML_PHOTO2;

/**
 * Created by jerry on 2018/7/6.
 */
public class MainPrenter extends BasePresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter {


    private boolean mIsRefresh;
    RecyclerView mRecyclerView;
    DataHelper dataHelper;

    @Inject
    public MainPrenter(DataHelper dataHelper) {
        this.dataHelper =dataHelper;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    protected MainContract.Model createModel() {
        return new MainModel(this);
    }


    private void showArticleList(FeedArticleListData feedArticleListData) {
        if (feedArticleListData == null) {
            return;
        }
        L.d("显示数据", mIsRefresh + ",showArticleList" + feedArticleListData.getDatas().get(0).getTitle());
        mView.showArticleList(feedArticleListData, mIsRefresh);
    }

    @Override
    public void FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page) {
        mIsRefresh = isRefresh;
        addDisposable(dataHelper.getFeedArticleList(page).subscribeOn(Schedulers.io()) //指定网络请求在IO线程
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
        addDisposable(dataHelper.getPopupPageReault(BaseHost.getUrl(NEWS_DETAIL_HTML_PHOTO2, "snspage/popupPage"), DeviceUtil.getUserAgent(getContext()), "application/x-www-form-urlencoded; charset=utf-8", params.parmsbuild(getContext())).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new BaseMvpObserver<BaseObj2<PopupPageResp>>() {
                    @Override
                    public void onNext(BaseObj2<PopupPageResp> popupPageRespBaseObj2) {
                        ToastUtils.showShort(getContext(), "6666666");
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                })
        );
    }

    @Override
    public void getRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }
}
