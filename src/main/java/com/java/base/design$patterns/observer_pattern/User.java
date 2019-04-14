package com.java.base.design$patterns.observer_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 上午11:53
 * 观察者模式
 */
public class User implements Observer {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notifyMessage(Subject subject,String str) {
        System.out.println("发布了新的工作:" + str + "，通知：" + this.name);
    }
}
