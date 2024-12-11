package com.java.base.lang;

import com.java.base.lang.domain.Person;

import java.io.*;
/**
 * User: jimjian
 * Date: 16-5-15 上午11:16
 * 序列化
 */
public class test_Serializable {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Jane");
        person.setAge(22);

        try {
            // 定义一个字节数组输出流
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            // 对象输出流
            ObjectOutputStream out = new ObjectOutputStream(os);
            // 将对象写入到字节数组输出，进行序列化
            out.writeObject(person);

            byte[] b = os.toByteArray();

            // 字节数组输入流
            ByteArrayInputStream is=new ByteArrayInputStream(b);
            // 执行反序列化，从流中取对象
            ObjectInputStream in=new ObjectInputStream(is);

            Person person1= (Person) in.readObject();
            System.out.println(person1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
