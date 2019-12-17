package com.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jianjie
 * Date: 16-3-17 Time: 下午4:26
 * -verbose:gc
 * -Xms2M
 * -Xmx2M
 * -XX:+PrintGCDetails
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/opt/dump
 * -Xloggc:/Users/jianjie/gc.log
 * -XX:+UseGCLogFileRotation
 * -XX:NumberOfGClogFiles=10
 * -XX:GCLogFileSize=100M
 * 内存溢出Java heap space
 */
public class test_OutOfMemoryError1 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList();
        while (true) {
            Thread.sleep(3000);
            list.add("a");
        }
    }
}
