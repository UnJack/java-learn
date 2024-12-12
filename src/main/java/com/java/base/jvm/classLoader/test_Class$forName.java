package com.java.base.jvm.classLoader;

/**
 * Created by jimjian on 2016/10/20.
 */
public class test_Class$forName {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader=test_Class$forName.class.getClassLoader();
        System.out.println(classLoader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        classLoader.loadClass("com.java.base.jvm.classLoader.Person");
//        //使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("com.java.base.jvm.classLoader.Person");
//        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
//        Class.forName("com.java.base.jvm.classLoader.Person",false,classLoader);
        System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());
    }
}