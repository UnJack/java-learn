package com.java.base.lang;

import com.java.base.lang.domain.Person;

import java.io.*;

/**
 * User: jimjian
 * Date: 16-7-13 上午10:38
 * 四种创建对象的方法
 */
public class test_NewObject {
    public static void main(String[] args) {
        try {
            // 反射创建对象
            Person person = (Person) Class.forName("com.java.base.bean.Person").newInstance();
            System.out.println(person);

            Person person1 = new Person("12", 12);
            Person p2 = cloneTo(person1);
            System.out.println(p2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 反序列化创建对象
    public static <T> T cloneTo(T t) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        T t1 = null;
        try {
            out = new ObjectOutputStream(byteArrayOutputStream);
            out.writeObject(t);
            out.flush();

            in = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            t1 = (T) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return t1;
    }
}
