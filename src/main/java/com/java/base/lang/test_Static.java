package com.java.base.lang;

/**
 * Created by jimjian on 2017/3/13.
 * 执行顺序：静态代码块>构造代码块>构造函数
 */
public class test_Static {
    static {
        System.out.println("静态代码块");
    }

    {
        //只要建立一个对象，构造代码块都会执行一次
        System.out.println("构造代码块");
    }

    public test_Static() {
        System.out.println("构造函数");
    }

    public static void main(String[] args) {
        new test_Static();
        new test_Static();
    }
}
