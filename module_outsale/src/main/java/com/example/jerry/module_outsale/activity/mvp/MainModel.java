package com.example.jerry.module_outsale.activity.mvp;

import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.module_basic.base.mvp.DisposablePool;
import com.example.jerry.module_outsale.activity.api.ApiService;
import com.example.jerry.module_outsale.activity.api.ModelMvpService;
import com.example.jerry.module_outsale.activity.bean.FeedArticleListData;

import io.reactivex.Observable;

/**
 * @author by TOME .
 * @data on      2018/7/3 17:43
 * @describe ${TODO}
 */

public class MainModel extends DisposablePool implements MainContract.Model {

    private MainPrenter mPresenter;

    public MainModel(MainPrenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page) {
//        return ModelMvpService.getFeedArticleList(page);
        return  ModelMvpService.getRemoteDataVp(new ModelMvpService.MethodSelect<FeedArticleListData>() {
            @Override
            public Observable<BaseObj<FeedArticleListData>> selectM(ApiService service) {
                return service.getFeedArticleList(page);
            }
        });
    }
}
