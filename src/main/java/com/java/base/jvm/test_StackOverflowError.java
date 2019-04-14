package com.java.base.jvm;

/**
 * User: jianjie
 * Date: 15-12-23 下午4:05
 * -Xss128k
 * 栈溢出
 */
public class test_StackOverflowError {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Exception {
        test_StackOverflowError javaVMStackSOF = new test_StackOverflowError();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + javaVMStackSOF.stackLength);
            throw e;
        }
    }
}
