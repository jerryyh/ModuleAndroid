package com.example.jerry.module_basic.net;

import com.example.jerry.comment_data.bean.BannerData;
import com.example.jerry.comment_data.bean.bean.BaseObj;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.comment_data.bean.FeedArticleListData;
import com.example.jerry.comment_data.bean.PopupPageResp;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @Created by TOME .
 * @时间 2018/5/15 18:18
 * @描述 ${TODO}
 */

public interface ApiService {

    String HOST = "http://www.wanandroid.com/";
    /**
     * 首页获取feed文章列表
     *
     * @param num 页数
     * @return Observable<FeedArticleListResponse>
     */
    @GET("article/list/{num}/json")
    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(@Path("num") int num);

    @FormUrlEncoded
    @POST
    Observable<BaseObj2<PopupPageResp>> getPopupPageReault(
            @Url String url,
            @Header("User-Agent") String userAgent,
            @Header("Content-Type") String contentType,
            @FieldMap Map<String, String> map
    );
    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 广告栏数据
     */
    @GET("banner/json")
    Observable<BaseObj<List<BannerData>>> getBannerData();
}
