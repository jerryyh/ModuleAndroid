package com.example.jerry.module_basic.net;

import com.example.jerry.comment_data.bean.BannerData;

import com.example.jerry.comment_data.bean.bean.BaseObj;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.bean.PopupPageResp;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * 网络接口
 * Created by jerry on 2018/7/16.
 */
public interface HttpHelper {

    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int num);


    Observable<BaseObj2<PopupPageResp>> getPopupPageReault(String url, String userAgent, String contentType, Map<String, String> map);

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 取消收藏页面站内文章数据
     */
    Observable<BaseObj<List<BannerData>>> getBannerData();
}
