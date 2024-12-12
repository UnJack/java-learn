package com.java.base.jvm.classLoader;

/**
 * Created by jimjian on 2016/10/26.
 */
public class Person implements Human{

    static {
        System.out.println("static person...");
    }

    @Override
    public void say() {
        System.out.println("classLoader Person~");
    }
}
