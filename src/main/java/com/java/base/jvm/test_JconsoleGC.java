package com.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jimjian
 * Date: 16-4-28 上午11:52
 * -verbose:gc -Xms100M -Xmx100M -XX:+UseSerialGC
 * 内存监控
 */
public class test_JconsoleGC {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
