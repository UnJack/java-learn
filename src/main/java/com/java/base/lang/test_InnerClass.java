package com.java.base.lang;

/**
 * User: jianjie
 * Date: 16-3-18 下午4:57
 * 内部类
 */
public class test_InnerClass {

    private static int i = 99;

    public static class a {
        int age = 24;

        public void print() {
            System.out.println("静态内部类age：" + age);
        }
    }

    class b {
        int i = 98;

        public void say() {
            int i = 97;
            System.out.println("内部类变量：" + this.i);
            System.out.println("外部类变量：" + test_InnerClass.i);
            System.out.println("局部变量" + i);
            System.out.println("我是内部类bb.b");
            new c().cat();
        }
    }

    private static class c {
        int j = 1992;
        public void cat() {
            System.out.println(j);
        }
    }

    public void e(final String str) {
        class f {
            public void ff() {
                System.out.println("方法内部类：" + str);
            }
        }
        new f().ff();
    }

    public static void main(String[] args) {
        // 静态内部类创建
        test_InnerClass.a a = new test_InnerClass.a();
        a.print();
        //
        test_InnerClass t = new test_InnerClass();
        test_InnerClass.b tb = t.new b();
        tb.say();
    }
}
