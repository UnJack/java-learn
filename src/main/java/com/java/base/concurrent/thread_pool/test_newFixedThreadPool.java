package com.java.base.concurrent.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: jianjie
 * Date: 16-3-31 下午6:35
 * 有界线程池
 */
//创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待.
//ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
//        long keepAliveTime, TimeUnit unit,
//        BlockingQueue workQueue,
//        RejectedExecutionHandler handler)

//        corePoolSize： 线程池维护线程的最少数量
//        maximumPoolSize：线程池维护线程的最大数量
//        keepAliveTime： 线程池维护线程所允许的空闲时间
//        unit： 线程池维护线程所允许的空闲时间的单位
//        workQueue： 线程池所使用的缓冲队列
//        handler： 线程池对拒绝任务的处理策略
//
//        一个任务通过 execute(Runnable)方法被添加到线程池，任务就是一个 Runnable类型的对象，任务的执行方法就是 Runnable类型对象的run()方法。
//
//        当一个任务通过execute(Runnable)方法欲添加到线程池时：
//
//        如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
//        如果此时线程池中的数量等于corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
//        如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
//        如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。
//
//        也就是：处理任务的优先级为：
//        核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
//        当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
//    executor.allowsCoreThreadTimeOut();
//    将包括“核心线程”在内的，没有任务分配的任何线程，在等待keepAliveTime时间后全部进行回收
//prestartAllCoreThreads 设置项，可以在线程池创建，但还没有接收到任何任务的情况下，先行创建符合corePoolSize参数值的线程数
public class test_newFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
