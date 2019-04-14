package com.java.base.jvm;

import java.util.ArrayList;
import java.util.List;
/**
 * User: jianjie
 * Date: 16-3-17 Time: 下午4:26
 * -verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:\dump
 * 内存溢出Java heap space
 */
public class test_OutOfMemoryError1 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();
        while(true) {
            Thread.sleep(3000);
            list.add("a");
        }
    }
}
