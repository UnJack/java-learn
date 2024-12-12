package org.learn.design.adapter;

public class dog implements eat {
    @Override
    public void dinner() {
        System.out.println("dog eat");
    }
}
