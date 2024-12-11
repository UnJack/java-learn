package com.java.base.jvm;

import java.util.ArrayList;

/**
 * User: jimjian
 * Date: 16-8-8 下午3:52
 * 测试消耗CPU的资源。
 * jstack pid|grep -A [pid的16进制]
 */
public class test_Cpu {
    public static void main(String[] args) throws Exception {
        test_Cpu demo = new test_Cpu();
        demo.runTest();
    }

    private void runTest() throws Exception {
        int count = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < count; i++) {
            new Thread(new ConsumeCPUTask()).start();
        }

        for (int i = 0; i < 200; i++) {
            new Thread(new NotConsumeCPUTask()).start();
        }
    }

    class ConsumeCPUTask implements Runnable {
        @Override
        public void run() {
            String str = "ddddddddddddddddddddddasdddddddddddddddddddddddddddddddddddddddddddddddddddasdadasd" +
                    "ddddddddddddddddddddddasddddddddddddddd#ddddddddddddddddddddddddddddddddddddasdadasd" +
                    "ddddddddddddddddddddddasdddddddddddddddddddddddddddddddddddddddddddddddddddasdadasd";
            float i = 0.002f;
            float j = 232.12321f;
            while (true) {
                j = i * j;
                str.indexOf("#");
                ArrayList<String> list = new ArrayList<>();
                for (int k = 0; k < 10000; k++)
                    list.add(str + String.valueOf(k));

                list.contains("iii");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class NotConsumeCPUTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
