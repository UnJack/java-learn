package com.java.base.lang;

/**
 * User: jimjian
 * Date: 15-12-14 Time: 下午4:21
 */
public class test_String {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Hel" + "lo";//只创建一个对象
        String str4 = "Hel" + new String("lo");
        String str5 = new String("Hello");
        String str6 = str5.intern();
        String str7 = "H";
        String str8 = "ello";
        //创建了3个对象，分别为StringBuilder，char[]，String
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        String str9 = str7 + str8;
        StringBuffer stringBuffer = new StringBuffer();
        //同步块
        stringBuffer.append("");
        // 检查字符串池里是否存在"abc"这么一个字符串，
        // 如果存在，就返回池里的字符串；
        // 如果不存在，该方法会把"abc"添加到字符串池中，然后再返回它的引用。
        String str10 = "Hello".intern();
        System.out.println("str1 == str2 " + (str1 == str2));      //true
        System.out.println("str1 == str3 " + (str1 == str3));      //true
        System.out.println("str1 == str4 " + (str1 == str4));      //false
        System.out.println("str1 == str9 " + (str1 == str9));      //false
        System.out.println("str1 == str5 " + (str1 == str5));      //false
        System.out.println("str1 == str6 " + (str1 == str6));      //true
        System.out.println("str2 == str3 " + (str2 == str3));      //true
        System.out.println("str4 == str5 " + (str4 == str5));      //false
        System.out.println("str5 == str6 " + (str5 == str6));      //false
        System.out.println("str1 == str10 " + (str1 == str10));    //true
        StringBuffer sb = new StringBuffer("my name is jian");
        //倒序
        System.out.println(sb.reverse().toString());
    }

}

