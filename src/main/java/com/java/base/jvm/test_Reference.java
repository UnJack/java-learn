package com.java.base.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * User: jimjian
 * Date: 16-6-13 上午10:37
 * 四种引用类型
 */
public class test_Reference {

    public static void main(String[] args) {

        // 强引用
        Person person = new Person();
        // 软引用
        // 当内存不足时会被回收，gc认为扫描到的softReference不经常使用也会进行回收
        // 可通过softReference.get()获取对象，可能返回为null
        SoftReference<Person> softReference = new SoftReference<Person>(person);

        // 弱引用
        // 采用弱引用建立的对象没有强引用后，gc会被自动释放
        WeakReference<Person> weakReference = new WeakReference<Person>(person);

        // 虚引用
        // 可跟踪到对象是否从内存中被删除
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<Person>();
        PhantomReference<Person> personPhantomReference = new PhantomReference<Person>(person, referenceQueue);

    }

    static class Person {
        String name;

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }
    }
}

