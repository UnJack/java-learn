package test;

import java.util.Date;
import java.util.Random;

public class test {

    public void doSomething() {
        Date date = new Date(10, 3, 3);
        // 这个构造函数被标记为deprecated, 编译时会
        // 向错误输出输出信息。
        System.out.println("Doing...");
//        p0
    }

    public int sum(int i, int j) {
//        k = 9;
        return i + j;
//        addd；
    }

    public static void main(String[] args) {
        Random random = new Random();
        random.nextInt(100);
        new test().doSomething();
    }
}
