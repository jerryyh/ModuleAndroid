package com.example.jerry.module_outsale.activity.api;

import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.module_outsale.activity.bean.BannerData;
import com.example.jerry.module_outsale.activity.bean.FeedArticleListData;
import com.example.jerry.module_outsale.activity.bean.KnowledgeChildBean;
import com.example.jerry.module_outsale.activity.bean.KnowledgeSystemBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @Created by TOME .
 * @时间 2018/5/15 18:18
 * @描述 ${TODO}
 */

public interface ApiService {

    String BASE_URL = "http://www.wanandroid.com/";

    /**
     * 首页获取feed文章列表
     *
     * @param num 页数
     * @return Observable<FeedArticleListResponse>
     */
    @GET("article/list/{num}/json")
    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(@Path("num") int num);

    @GET("article/list/{num}/json")
    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(@Path("num") int num, @QueryMap Map<String, String> map);

//    @FormUrlEncoded
//    @POST("/api/product/getProductProperty")
//    Observable<BaseEntity<ProductPropertiesBean>> getProductProperty(@FieldMap Map<String, String> map);

    //  上传头像
 //   @POST("/api/upload/upload")
 //   Observable<BaseEntity<UploadResultBean>> upload(@Body MultipartBody file);

    /**
     * 首页广告栏
     * @return
     */
    @GET("banner/json")
    Observable<BaseObj<List<BannerData>>> getBannerData();

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     *
     * @return Observable<KnowledgeHierarchyResponse>
     */
    @GET("tree/json")
    Observable<BaseObj<List<KnowledgeSystemBean>>> getKnowledgeHierarchyData();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0?cid=60
     *
     * @param page page num
     * @param cid second page id
     * @return Observable<FeedArticleListResponse>
     */
    @GET("article/list/{page}/json")
    Observable<BaseObj<KnowledgeChildBean>> getKnowledgeHierarchyDetailData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 导航
     * http://www.wanandroid.com/navi/json
     *
     * @return Observable<NavigationListResponse>
     */
//    @GET("navi/json")
//    Observable<BaseObj<List<NavigationBean>>> getNavigationListData();
}
