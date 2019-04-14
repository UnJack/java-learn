package com.java.base.design$patterns.proxy_jdk_pattern;

/**
 * Created by JianJie on 16/9/6.
 */
public class Women implements Person{
    @Override
    public void eat(String str) {
        System.out.println("Women = " + str);
    }
}
