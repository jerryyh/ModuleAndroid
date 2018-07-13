package com.example.jerry.module_outsale.activity.mvp;


import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.module_basic.base.mvp.inter.IModel;
import com.example.jerry.module_basic.base.mvp.inter.IPresenter;
import com.example.jerry.module_basic.base.mvp.inter.IView;
import com.example.jerry.module_basic.net.params.RequestMapParams;
import com.example.jerry.module_outsale.activity.bean.FeedArticleListData;
import com.example.jerry.module_outsale.activity.bean.PopupPage;
import com.example.jerry.module_outsale.activity.bean.PopupPageResp;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import io.reactivex.Observable;

/**
 * @Created by TOME .
 * @时间 2018/5/4 11:15
 * @描述 ${契约}
 */

public interface MainContract {

    interface View extends IView {

        void showTestData(String feedArticleListData);

    }

    interface Presenter extends IPresenter<View> {
        /**
         * 获取文章数据
         *
         * @param isRefresh
         * @param rlRefreshLayout
         * @param page
         */
        void FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page);

        void getPopuPageResult();
    }

    interface Model extends IModel {
        /**
         * 获取条目数据
         *
         * @param page
         */
        Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page);


        Observable<BaseObj2<PopupPageResp>> getPopuPageResult (RequestMapParams params);
    }
}
