package com.java.base.instrumentation.proxy_jdk_pattern;

public class Women implements Person {
    @Override
    public void eat(String str) {
        System.out.println("Women = " + str);
    }
}
