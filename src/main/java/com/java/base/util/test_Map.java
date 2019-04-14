package com.java.base.util;

import com.java.base.lang.domain.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * User: jianjie
 * Date: 16-8-3 下午5:38
 * 对象作为key，equals,hashCode重写
 * 因为所有的对象父类都是Object
 * <p>
 * public boolean equals(Object obj) {
 * return (this == obj);
 * }
 * <p>
 * public native int hashCode();
 */
public class test_Map {

    public static void main(String[] args) {
        Person p0 = new Person("person1", 20);
        Person p1 = new Person("person1", 20);
        Person p2 = new Person("person2", 21);
        Person p3 = new Person("person3", 22);
        Map<Person, String> hashMap = new HashMap();
        hashMap.put(p1, "boy1");
        hashMap.put(p2, "boy2");
        hashMap.put(p3, "boy3");
        System.out.println(hashMap.get(p0));
        System.out.println(hashMap.get(p1));
        System.out.println(hashMap.get(new Person("person2", 21)));
    }
}
