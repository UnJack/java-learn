package com.java.base.concurrent;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: jianjie
 * Date: 16-3-28 下午2:59
 * http://www.cnblogs.com/maypattis/p/6403682.html
 */
public class test_Lock_ReentrantLock_lockInterruptibly {

    @Test
    public void test1() throws Exception{
        final Lock lock=new ReentrantLock();
        //lock()忽视interrupt(), 拿不到锁就一直阻塞
        lock.lock();
        Thread.sleep(1000);
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }

    @Test
    public void test2() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //lockInterruptibly()优先考虑响应中断，而不是响应锁定的普通获取或重入获取
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("#log error:" + e);
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "child thread -1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName());
    }

}