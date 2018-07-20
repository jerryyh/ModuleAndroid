package com.example.jerry.module_outsale.activity.mvp.home;

import com.example.jerry.comment_data.bean.BannerData;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.module_basic.base.mvp.inter.IModel;
import com.example.jerry.module_basic.base.mvp.inter.IPresenter;
import com.example.jerry.module_basic.base.mvp.inter.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;


/**
 * Created by jerry on 2018/7/20.
 */
public interface HomeMvpContract {
    interface View extends IView {
        /**
         * Show banner data
         *
         * @param bannerDataList List<BannerData>
         */
        void showBannerData(List<BannerData> bannerDataList);

        void showArticleList(FeedArticleListData feedArticleListData, boolean mIsRefresh);

    }

    interface Presenter extends IPresenter<View> {
        void getBannerData(SmartRefreshLayout normalView);
        /**
         * 获取文章数据
         *
         * @param isRefresh
         * @param rlRefreshLayout
         * @param page
         */
        void FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page);
    }

    interface Model extends IModel {

    }
}
