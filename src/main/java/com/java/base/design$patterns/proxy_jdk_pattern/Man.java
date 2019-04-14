package com.java.base.design$patterns.proxy_jdk_pattern;

/**
 * User: jianjie
 * Date: 16-4-15 下午3:33
 */
public class Man implements Person {
    @Override
    public void eat(String str) {
        System.out.println("Man = " + str);
    }
}
