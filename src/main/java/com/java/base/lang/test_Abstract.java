package com.java.base.lang;

/**
 * User: jimjian
 * Date: 16-6-1 下午4:38
 */
public class test_Abstract {

    public static void main(String[] args) {
        System.out.println(interfaceClass.a);
    }

    interface interfaceClass {
        // 默认是public,static,final
        public static final int a = 123456;

        // 默认是public
        public void inter();
    }

    abstract class abstractClass {
        public int i=9;
        public abstract void say();

        public void say(String str) {
        }
    }
}