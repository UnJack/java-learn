package com.java.base.lang.domain;

import java.io.Serializable;

/**
 * Created by jian.jie on 2016/8/26.
 */
public class Person implements Serializable {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person && ((Person) o).name.equals(this.name) && ((Person) o).age == this.age)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

