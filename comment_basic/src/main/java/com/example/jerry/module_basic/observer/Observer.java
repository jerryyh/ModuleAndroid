package com.example.jerry.module_basic.observer;

/**
 * 当被观察者发生改变时，观察者进行的行为动作
 - 提供一个统一的方法名便于被调用
 * 观察者接口
 * Created by jerry on 2018/7/14.
 */
public interface Observer {
    /**
     * 当被观察者发生改变时，观察者进行的行为动作
     * @param objects
     */
    void action(int id,Object... objects);
}
