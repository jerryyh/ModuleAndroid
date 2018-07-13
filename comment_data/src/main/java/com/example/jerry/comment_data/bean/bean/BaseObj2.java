package com.example.jerry.comment_data.bean.bean;

/**
 * @Created by TOME .
 * @时间 2018/5/31 16:36
 * @描述 ${TODO}
 */

public class BaseObj2<T> {
    private int state;
    private String errorCode;
    private String msg;
    private T data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
