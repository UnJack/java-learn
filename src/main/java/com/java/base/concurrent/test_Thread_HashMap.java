package com.java.base.concurrent;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: jianjie
 * Date: 16-6-14 下午5:24
 */
public class test_Thread_HashMap {
//     hashMap非线程安全并发下，由于多线程的冲突，这个链表的结构已
//     经遭到了破坏，链表成环了！当链表成环时，上述的迭代就等同于一个死循环.
//    static Map<String, String> map = new HashMap<>();
    //线程安全
    static Map<String, String> map = new Hashtable<>();
//    ConcurrentHashMap是线程安全的
//    static Map<String, String> map = new ConcurrentHashMap<>();

    public static class AddThread implements Runnable {
        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new test_Thread_HashMap.AddThread(0));
        Thread t2 = new Thread(new test_Thread_HashMap.AddThread(1));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(map.size());

    }
}
