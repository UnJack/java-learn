package com.java.base.lang;

/**
 * User: jimjian
 * Date: 16-7-28 上午10:42
 */
public class test_Integer {
    public static void main(String[] args){
        int i1 = 128;
        int i2 = 128;
        Integer i3 = 128;
        Integer i4 = 128;
        // Integer -128~127的缓存值范围
        Integer i5 = new Integer(128);
        i5.intValue();
        Integer i6 = new Integer(127);
        Integer i7 = new Integer(127);
        Integer i8 = 127;
        Integer i9 = 127;
        Integer i10 = 128;
        System.out.println("i1 == i2 " + (i1 == i2)); //true
        System.out.println("i1 == i3 " + (i1 == i3)); //true
        System.out.println("i1 == i5 " + (i1 == i5)); //true
        System.out.println("i3 == i4 " + (i3 == i4)); //false*
        System.out.println("i6 == i7 " + (i6 == i7)); //false
        System.out.println("i8 == i9 " + (i8 == i9)); //true
        System.out.println("i7 == i9 " + (i7 == i9)); //false
        System.out.println("i1 == i10 " + (i1 == i10)); //true
    }
}
