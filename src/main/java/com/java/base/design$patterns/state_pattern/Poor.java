package com.java.base.design$patterns.state_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 下午2:54
 */
public class Poor implements State{
    @Override
    public void saySomething(StateContext sc) {
        System.out.println("I'm poor currently, and spend much time working.");
        sc.changeState(new Rich());
    }
}