package com.example.jerry.module_outsale.activity.api;


import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.module_basic.net.HttpHelper;
import com.example.jerry.module_basic.util.RxUtils;
import com.example.jerry.module_outsale.activity.bean.FeedArticleListData;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @author by jerry .
 * @data on      2018/6/29 11:33
 * @describe ${mvp}
 */

public class ModelMvpService {

    private ModelMvpService mMvpService;
    private ModelMvpService mService;

    /**
     * 获取api的回调
     * @param <T>
     */
    public interface MethodSelect<T>{
        Observable<BaseObj<T>> selectM(ApiService service);
    }

    public ModelMvpService(ModelMvpService modelService) {
        mMvpService = modelService;
    }

    public static <T> Observable<BaseObj<T>> getRemoteDataVp(MethodSelect<T> select) {
        //设置不同的BaseUrl
        return select.selectM(HttpHelper.getDefault(1).create(ApiService.class))
//                .compose(RxUtils.<BaseObj<T>>rxSchedulerHelper())
                ;
    }

    public static Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int pageNum) {
        //设置不同的BaseUrl
        Retrofit retrofit = HttpHelper.getDefault(1);
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getFeedArticleList(pageNum);
    }
}
