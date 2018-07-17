package com.example.jerry.module_outsale.activity.api;


import com.example.jerry.comment_data.bean.BaseObj;
import com.example.jerry.module_basic.net.ApiService;
import com.example.jerry.module_basic.net.common_callback.INetCallback;

import io.reactivex.Observable;

/**
 * @Created by TOME .
 * @时间 2018/5/16 9:52
 * @描述 ${TODO}
 */

public class ModelMvcService {

    private ModelMvcService mModelService;
    private INetCallback mCallback;

    /**
     * 获取api的回调
     * @param <T>
     */
    public interface MethodSelect<T>{

        Observable<BaseObj<T>> selectM(ApiService service);
    }

    public ModelMvcService(ModelMvcService modelService) {
        mModelService = modelService;
    }

    /**
     * 获取远程基本数据 mvc模式
     * 带进度条的方法
     * @return
     * @param isShowHUD
     * @param mView
     * @param select
     * @param callback
     * @param <T>
     * @return
     */
//    public static <T> BaseVcObserver<BaseObj<T>> getRemoteData(boolean isShowHUD, IView mView, MethodSelect<T> select, INetCallback<T> callback) {
//        //设置不同的BaseUrl
//        return select.selectM(HttpHelper.getDefault(1)
//                .create(ApiService.class))
//                .compose(RxUtils.<BaseObj<T>>rxSchedulerHelper())
//                .subscribeWith(new BaseVcObserver<BaseObj<T>>(mView, isShowHUD) {
//                                   @Override
//                                   public void onNext(BaseObj<T> result) {
//                                       L.d("获取message", ":" + result.getMessage());
//                                       if (BaseResponse.SUCCESS.equals(result.getCode())) {
//                                           callback.onSuccess(result.getData());
//                                       } else {
//                                           mView.showError(result.getMessage(), result.getCode());
//                                       }
//                                   }
//                               }
//                );
//    }



    /**
     * 封装了list的刷新
     * @param mView
     * @param select
     * @param callback
     * @param <T>
     * @return
     */
//    public static <T> BaseVcObserver<BaseObj<T>> getRemoteListData(IView mView, SmartRefreshLayout rlRefresh, MethodSelect<T> select, INetCallback<T> callback) {
//        //设置不同的BaseUrl
//        return select.selectM(HttpHelper.getDefault(1)
//                .create(ApiService.class))
//                .compose(RxUtils.<BaseObj<T>>rxSchedulerHelper())
//                .subscribeWith(new BaseVcObserver<BaseObj<T>>(mView, rlRefresh,false) {
//                                   @Override
//                                   public void onNext(BaseObj<T> result) {
//                                       L.d("获取message", ":" + result.getMessage());
//                                       if (BaseResponse.SUCCESS.equals(result.getCode())) {
//                                           callback.onSuccess(result.getData());
//                                       } else {
//                                           mView.showError(result.getMessage(), result.getCode());
//                                       }
//                                   }
//                               }
//                );
//    }

}
