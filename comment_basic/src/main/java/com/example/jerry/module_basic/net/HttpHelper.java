package com.example.jerry.module_basic.net;

import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.bean.PopupPageResp;

import java.util.Map;

import io.reactivex.Observable;

/**
 * 网络接口
 * Created by jerry on 2018/7/16.
 */
public interface HttpHelper {

    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int num);


    Observable<BaseObj2<PopupPageResp>> getPopupPageReault(String url, String userAgent, String contentType, Map<String, String> map);
}
