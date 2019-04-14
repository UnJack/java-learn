package com.java.base.jvm;

/**
 * User: jianjie
 * Date: 15-12-23 Time: 下午4:13
 * VM args:-Xss2M
 * 堆溢出
 */
public class test_OutOfMemoryError2 {

    private void Stop() {
        while (true) {

        }
    }

    //线程映射到操作系统内核线程上，此处也为堆溢出
    public void stackLeakByThread() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Stop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        test_OutOfMemoryError2 javaVMStackOOM = new test_OutOfMemoryError2();
        javaVMStackOOM.stackLeakByThread();
    }
}
