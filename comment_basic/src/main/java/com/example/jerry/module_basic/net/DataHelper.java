package com.example.jerry.module_basic.net;

import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.bean.PopupPageResp;
import com.example.jerry.comment_data.bean.bean.BaseObj2;

import java.util.Map;

import io.reactivex.Observable;

/**
 * DataHelper是HttpHelper的实现类，他的唯一作用就是调用接口的方法即可，具体的功能实现是由HttpHelperImpl
 * Created by jerry on 2018/7/16.
 */
public class DataHelper implements HttpHelper {

    private HttpHelper httpHelper;

    public DataHelper(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int num) {
        return httpHelper.getFeedArticleList(num);
    }

    @Override
    public Observable<BaseObj2<PopupPageResp>> getPopupPageReault(String url, String userAgent, String contentType, Map<String, String> map) {
        return httpHelper.getPopupPageReault(url, userAgent, contentType, map);
    }
}
