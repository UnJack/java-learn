package com.java.base.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * User: jianjie
 * Date: 16-3-24 上午10:24
 */
public class test_CountDownLatch1 {

    public static void main(String[] args) {
        CountDownLatch doneSignal = new CountDownLatch(10);
        CountDownLatch startSignal = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(i, doneSignal, startSignal)).start();
        }
        try {
            startSignal.countDown();
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 百米大战开始...");
    }

    static class Worker implements Runnable {
        private CountDownLatch startSignal;
        private CountDownLatch doneSignal;
        private int i;

        Worker(int i, CountDownLatch doneSignal, CountDownLatch startSignal) {
            this.i = i;
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await();
                Thread.sleep(new Random().nextInt(10000));
                System.out.println(i + " 号选手准备就绪");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                doneSignal.countDown();
            }
        }
    }
}


