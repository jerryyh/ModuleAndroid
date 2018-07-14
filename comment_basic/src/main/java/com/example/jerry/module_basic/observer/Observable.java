package com.example.jerry.module_basic.observer;

import java.util.ArrayList;

/**
 * 被观察者接口
 * 功能：
 * - 注册观察者
 * - 注销观察者
 * - 提醒观察者进行动作更新
 * Created by jerry on 2018/7/14.
 */
public abstract class Observable<T> {

    public final ArrayList<T> observerList = new ArrayList<>();

    public void registerObserver(T t) {
        checkNull(t);
        observerList.add(t);
    }

    /**
     * 注销观察者对象
     *
     * @param t
     */
    public void unRegisterObserver(T t) {
        checkNull(t);
        observerList.remove(t);
    }

    /**
     * 判断所传的观察者对象是否为空
     *
     * @param t
     */
    private void checkNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
    }

    /**
     * 通知观察者做出行为改变
     *
     * @param objects
     */
    public abstract void notifyObservers(int id,Object... objects);
}
