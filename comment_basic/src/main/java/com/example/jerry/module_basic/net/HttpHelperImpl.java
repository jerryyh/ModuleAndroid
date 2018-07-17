package com.example.jerry.module_basic.net;

import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.bean.PopupPageResp;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * HttpHelperImpl类作为HttpHelper接口的实现类，他是具体功能的实现类
 * Created by jerry on 2018/7/16.
 */
public class HttpHelperImpl implements HttpHelper {

    private ApiService apiService;

    @Inject
    public HttpHelperImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int num) {
        return apiService.getFeedArticleList(num);
    }

    @Override
    public Observable<BaseObj2<PopupPageResp>> getPopupPageReault(String url, String userAgent, String contentType, Map<String, String> map) {
        return apiService.getPopupPageReault(url, userAgent, contentType, map);
    }
}
