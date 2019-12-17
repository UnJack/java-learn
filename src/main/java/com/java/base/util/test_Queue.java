package com.java.base.util;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: jianjie
 * Date: 16-7-20 下午5:53
 */
public class test_Queue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> linkBlockingQueue = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            //add如果队列已满，会抛异常
//            linkBlockingQueue.add(i);
            //将指定的元素添加到队列的尾部，如有必要，则等待空间变得可用，如果空间满了，则会一直等到空间可用时，进行插入。
//            linkBlockingQueue.put(i);
            //在尾部插入一个元素，如果有必要，等待指定的时间，使得队列变得可用。返回boolean值  表示是否插入成功。
            linkBlockingQueue.offer(i);
        }

//        for (Integer integer : linkBlockingQueue)
//            System.out.println(integer);

        //出队列
//        linkBlockingQueue.poll();
        linkBlockingQueue.take();
        System.out.println("size:" + linkBlockingQueue.size());

        //ArrayBlockingQueue只有1个锁，添加数据和删除数据的时候只能有1个被执行，不允许并行执行。
        //而LinkedBlockingQueue有2个锁，放锁和拿锁，添加数据和删除数据是可以并行进行的，
        // 当然添加数据和删除数据的时候只能有1个线程各自执行。
        Queue<String> arrayBlockingQueue = new ArrayBlockingQueue(5);
        arrayBlockingQueue.offer("1");
        arrayBlockingQueue.offer("2");
        arrayBlockingQueue.offer("3");
        arrayBlockingQueue.offer("4");
        for (String string : arrayBlockingQueue) {
            System.out.println("s = " + string);
        }
    }
}
