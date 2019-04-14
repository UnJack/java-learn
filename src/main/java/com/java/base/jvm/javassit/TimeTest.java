package com.java.base.jvm.javassit;

public class TimeTest {

    public static void main(String[] args) {
        boy();
        girl("hello world girl~");
    }

    public static void boy() {
        try {
            Thread.sleep(2000);
            System.out.println("hello world boy~");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void girl(String hello) {
        try {
            Thread.sleep(1000);
            System.out.println(hello);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}