package com.java.base.jdk1_8;

/**
 * Created by JianJie on 2017/8/19.
 * 1.8语法
 */
public class test_1_8Thread {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("jdk1.8 Thread = " + 1.8);
        }).start();
    }

}
