package com.example.jerry.comment_data.bean;


import com.example.jerry.comment_data.bean.bean.BaseResponse;

/**
 * @author quchao
 * @date 2018/2/26
 */

public class LoginResponse extends BaseResponse {

    private LoginBean data;

    public LoginBean getData() {
        return data;
    }

    public void setData(LoginBean data) {
        this.data = data;
    }
}
