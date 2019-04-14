package com.java.base.design$patterns.state_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 下午2:53
 */
public class Rich implements State{
    @Override
    public void saySomething(StateContext sc) {
        System.out.println("I'm rick currently, and play a lot.");
        sc.changeState(new Poor());
    }
}