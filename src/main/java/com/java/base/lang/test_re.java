package com.java.base.lang;

/**
 * Created by jimjian on 2017/3/19.
 */
public class test_re {

    public static void main(String[] args) {
        // 主动引用
        System.out.println(SubClass.value);

        // 被动引用
        SuperClass[] superClasses = new SuperClass[10];
        System.out.println(ConstClass.HELLO_WORLD);
    }

}

class SuperClass {
    static {
        System.out.println("superClass static...");
    }

    public static int value = 25;
}

class SubClass extends SuperClass {
    static {
        System.out.println("subClass static...");
    }
}

class ConstClass {
    static {
        System.out.println("constClass static...");
    }

    public static final String HELLO_WORLD = "hello world";
}
