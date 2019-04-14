package com.java.base.util;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: jianjie
 * Date: 16-3-31 下午4:35
 * 集合
 */
public class test_Collections {

    public static void main(String[] args) {

        // 非线程安全，继承Collection接口，default size：10，按50%的比例扩容
        List<String> list = new ArrayList<>(1);
        list.add("简杰");
        list.add("北京市海淀区");
        System.out.println("List = " + list);

        // 继承Collection接口
        Set<String> set = new TreeSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        System.out.println("TreeSet = " + set);

        //add,remove通过ReentrantLock保证同步，查询速度快，写的速度慢
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("CopyOnWriteArrayList");

        // 非线程安全，继承AbstractMap，default size：16
        Map hashMap = new HashMap();
        hashMap.put("name", "简杰");
        hashMap.put("address", 24);
        System.out.println("HashMap = " + hashMap);

        // 线程安全，继承Dictionary，default size：11
        Map hashTable = new Hashtable();
        hashTable.put("name", "简杰");
        hashTable.put("address", 24);
        System.out.println("HashTable = " + hashTable);

        Map concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("age", "25");
        concurrentHashMap.put("name", "简杰");
        concurrentHashMap.put("address", "北京市海淀区");
        System.out.println("ConcurrentHashMap = " + concurrentHashMap);

        // 可以指定排序器Comparator
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("2", "1");
        treeMap.put("6", "1");
        treeMap.put("1", "1");
        treeMap.put("4", "1");
        System.out.println("TreeMap 输出 = " + treeMap);
        //制定Comparator降序输出
        treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        treeMap.put("2", "1");
        treeMap.put("6", "1");
        treeMap.put("1", "1");
        treeMap.put("4", "1");
        System.out.println("TreeMap 排序之后 = " + treeMap);

        //ArrayBlockingQueue只有1个锁，添加数据和删除数据的时候只能有1个被执行，不允许并行执行。
        Queue<String> arrayBlockingQueue = new ArrayBlockingQueue(5);

        //而LinkedBlockingQueue有2个锁，放锁和拿锁，添加数据和删除数据是可以并行进行的，
        // 当然添加数据和删除数据的时候只能有1个线程各自执行。
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        System.out.println(linkedBlockingQueue.offer("1"));
        System.out.println(linkedBlockingQueue.offer("2"));
        System.out.println(linkedBlockingQueue.offer("3"));
        System.out.println(linkedBlockingQueue.offer("4"));
        try {
            //put方法超过队列长度卡死
            linkedBlockingQueue.put("5");
            linkedBlockingQueue.put("6");
            linkedBlockingQueue.put("7");
            linkedBlockingQueue.put("8");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before queue.size() = " + linkedBlockingQueue.size());
        String str;
        while ((str = linkedBlockingQueue.poll()) != null) {
            System.out.println(str);
        }
        System.out.println("after queue.size() = " + linkedBlockingQueue.size());
    }
}
