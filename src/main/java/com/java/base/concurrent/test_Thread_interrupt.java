package com.java.base.concurrent;

/**
 * User: jianjie
 * Date: 16-3-30 下午5:58
 * 线程阻塞中断demo
 */
public class test_Thread_interrupt {

    //Thread.interrupt()方法不会中断一个正在运行的线程。
    // 它的作用是，在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态。
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(new InterruptThread1());
        Thread t = new Thread(new InterruptThread2());
        t.start();
        Thread.sleep(2000);

        System.out.println("****************************");
        System.out.println(" Interrupted Thread!");
        System.out.println("****************************");

        t.interrupt();//中断线程
        System.out.println(" end!");
    }

    static class InterruptThread1 implements Runnable {
        private double d = 0.0;

        public void run() {
            //死循环执行打印"I am running!" 和做消耗时间的浮点计算
            try {
                while (true) {
                    System.out.println("I am running!");
                    for (int i = 0; i < 900000; i++) {
                        d = d + (Math.PI + Math.E) / d;
                    }
                    //休眠一断时间,中断时会抛出InterruptedException
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptThread.run() interrupted!");
            }
        }
    }

    static class InterruptThread2 implements Runnable {
        private double d = 0.0;

        public void run() {
            //检查程序是否发生中断
            while (!Thread.interrupted()) {
                System.out.println("I am running!");
                for (int i = 0; i < 900000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
            }
            System.out.println("InterruptThread.run() interrupted!");
        }
    }

}
