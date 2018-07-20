package com.example.jerry.module_outsale.activity.mvp.user;

import com.example.jerry.module_basic.base.mvp.inter.IModel;
import com.example.jerry.module_basic.base.mvp.inter.IPresenter;
import com.example.jerry.module_basic.base.mvp.inter.IView;

/**
 * Created by jerry on 2018/7/20.
 */
public interface UserMvpContract {
    interface View extends IView{

    }
    interface  Presenter extends IPresenter<View>{

    }

    interface Model extends IModel {

    }
}
