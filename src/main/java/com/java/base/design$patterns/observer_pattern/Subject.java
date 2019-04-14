package com.java.base.design$patterns.observer_pattern;


/**
 * User: jianjie
 * Date: 16-3-23 上午11:48
 */
public interface Subject {

    public void postNewJob(String job);

    public void registerUser(Observer observer);

    public void notifyAllUser(String str);
}
