//package com.java.base.jdk1_8;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by jianjie on 2017/8/2.
// * Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
// */
//public class test {
//    public static void main(String[] args) {
//        int max = 1000000;
//        List<String> values = new ArrayList<>(max);
//        for (int i = 0; i < max; i++) {
//            UUID uuid = UUID.randomUUID();
//            values.add(uuid.toString());
//        }
//
//        long t0 = System.nanoTime();
//        long count = values.stream().sorted().count();
//        System.out.println(count);
//        long t1 = System.nanoTime();
//        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//        System.out.println(String.format("sequential sort took: %d ms", millis));
//
//        System.out.println("``````````````````````````````````````````````````");
//
//        long t00 = System.nanoTime();
//        long count1 = values.parallelStream().sorted().count();
//        System.out.println(count1);
//        long t11 = System.nanoTime();
//        long millis1 = TimeUnit.NANOSECONDS.toMillis(t11 - t00);
//        System.out.println(String.format("parallel sort took: %d ms", millis1));
//    }
//}
