package com.java.base.design$patterns.observer_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 上午11:57
 * 观察者模式
 */
public class test_Observer_pattern {

    public static void main(String[] args) {
        HeadHunter h = new HeadHunter();
        h.registerUser(new User("jeff"));
        h.registerUser(new User("jane"));
        h.registerUser(new User("lynn"));
        h.postNewJob("乐视招聘");
        System.out.println("----------------");
        h.postNewJob("阿里招聘");
        System.out.println("----------------");
        h.postNewJob("百度招聘");
    }
}
