package com.example.jerry.module_outsale.activity.mvp;

import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.comment_data.bean.bean.BaseObj2;
import com.example.jerry.comment_data.constant.BaseHost;
import com.example.jerry.module_basic.base.mvp.DisposablePool;
import com.example.jerry.module_basic.net.params.RequestMapBuild;
import com.example.jerry.module_basic.net.params.RequestMapParams;
import com.example.jerry.module_basic.util.DeviceUtil;
import com.example.jerry.module_outsale.activity.api.ApiService;
import com.example.jerry.module_outsale.activity.api.ModelMvpService;
import com.example.jerry.module_outsale.activity.bean.FeedArticleListData;
import com.example.jerry.module_outsale.activity.bean.PopupPageResp;

import io.reactivex.Observable;

import static com.example.jerry.comment_data.constant.HostType.NEWS_DETAIL_HTML_PHOTO2;

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

    @Override
    public Observable<BaseObj2<PopupPageResp>> getPopuPageResult(RequestMapParams params) {
        return ModelMvpService.getPopuPage(new ModelMvpService.MethodSelect2<PopupPageResp>() {
            @Override
            public Observable<BaseObj2<PopupPageResp>> selectM2(ApiService service) {
                return service.getPopupPageReault(BaseHost.getUrl(NEWS_DETAIL_HTML_PHOTO2,"snspage/popupPage"),DeviceUtil.getUserAgent(mPresenter.getContext()),"application/x-www-form-urlencoded; charset=utf-8",params.parmsbuild(mPresenter.getContext()));
            }
        });
    }
}
