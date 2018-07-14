package com.example.jerry.module_outsale.activity.mvp.mall;

import com.example.jerry.module_basic.base.mvp.inter.IModel;
import com.example.jerry.module_basic.base.mvp.inter.IPresenter;
import com.example.jerry.module_basic.base.mvp.inter.IView;

/**
 * Created by jerry on 2018/7/14.
 */
public interface MallContract {

    interface  View extends IView{

    }

    interface  Presenter extends IPresenter<View>{

    }

    interface  Model extends IModel{

    }
}
