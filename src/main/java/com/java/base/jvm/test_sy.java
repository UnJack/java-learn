package com.java.base.jvm;

import java.util.Random;

/**
 * User: jimjian
 * Date: 16-8-8 下午4:25
 * 测试sy(内核线程处理所占的百分比)高的情况
 */
public class test_sy {
    private static int threadCount = 500;
    private Random random = new Random();
    private Object[] locks;

    public static void main(String[] args) throws Exception {

        if (args.length == 1)
            threadCount = Integer.parseInt(args[0]);

        test_sy s = new test_sy();
        s.runTest();
    }

    public void runTest() throws Exception {
        locks = new Object[threadCount];
        for (int i = 0; i < threadCount; i++)
            locks[i] = new Object();

        for (int i = 0; i < threadCount; i++) {
            new Thread(new ATask(i)).start();
            new Thread(new BTask(i)).start();
        }

    }

    class ATask implements Runnable {
        private Object lockObject = null;

        public ATask(int i) {
            lockObject = locks[i];
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lockObject) {
                        lockObject.wait(random.nextInt(10));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class BTask implements Runnable {
        private Object lockObject = null;

        public BTask(int i) {
            lockObject = locks[i];
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lockObject) {
                    lockObject.notifyAll();
                }
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
