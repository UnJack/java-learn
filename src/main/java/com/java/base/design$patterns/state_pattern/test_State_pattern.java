package com.java.base.design$patterns.state_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 下午3:10
 */
public class test_State_pattern {
    public static void main(String args[]){
        StateContext sc = new StateContext();
        sc.saySomething();
        sc.saySomething();
        sc.saySomething();
        sc.saySomething();
    }
}