package com.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jianjie
 * Date: 16-4-27 下午4:23
 */
public class test_OutOfMemoryError3 {

    public static void main(String[] args) {
        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();

        int i = 0;
        while (true) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(String.valueOf(i++).intern());
        }
    }
}
