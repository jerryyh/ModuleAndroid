package com.example.jerry.module_sns.arouter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.jerry.comment_data.d_arouter.RouterURLS;


/**
 * @描述 ${路由中心}
 */
//ARouter 提供了大量的参数类型 跳转携带 https://blog.csdn.net/zhaoyanjun6/article/details/76165252
public class RouterCenter {
    /**
     * 测试首页
     */
    public static void toMain() {
        ARouter.getInstance().build(RouterURLS.BASE_MAIN).navigation();
    }

    /**
     * shopCart 模块页面
     */
    public static void toOutSale() {
        ARouter.getInstance().build(RouterURLS.MALL_MAIN).navigation();
    }



}
