package com.example.jerry.module_basic.observer;

/**
 * 被观察者对象
 * Created by jerry on 2018/7/14.
 */
public class ActivityObservable extends Observable<Observer> {

    private static ActivityObservable mActivityObservable = null;

    public static ActivityObservable getInstance() {
        if (mActivityObservable == null) {
            mActivityObservable = new ActivityObservable();
        }

        return mActivityObservable;
    }
    @Override
    public void notifyObservers(int id,Object... objects) {
        for (Observer observer:observerList) {
            if(observer!=null){
                observer.action(id,objects);
            }
        }
    }
}
