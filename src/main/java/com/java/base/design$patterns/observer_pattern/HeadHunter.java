package com.java.base.design$patterns.observer_pattern;


import java.util.ArrayList;
import java.util.List;

/**
 * User: jianjie
 * Date: 16-3-23 上午11:48
 */
public class HeadHunter implements Subject {

    private List<Observer> userList = new ArrayList<>();
    private List<String> josList = new ArrayList<>();

    @Override
    public void postNewJob(String job) {
        josList.add(job);
        notifyAllUser(job);
    }

    public void registerUser(Observer o) {
        this.userList.add(o);
    }

    @Override
    public void notifyAllUser(String str) {
        for (Observer o : userList)
            o.notifyMessage(this, str);
    }
}
