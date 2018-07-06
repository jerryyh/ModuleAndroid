package com.example.jerry.comment_data.d_arouter;

/**
 * @时间 2018/4/26 10:20
 * @描述 ${路由地址}
 */
// 注意事项！！！  /模块/页面名称   或  /模块/子模块../页面名称   至少两级  例子 /商城/商品详情 /shop/shopDetails
    //url 第一次相同会报错??
public interface RouterURLS {

    String MEMBER_INFORMATION = "/member/information";
    String BASE_MAIN = "/base/main";
    String MALL_MAIN= "/mall/main/activity";

}
