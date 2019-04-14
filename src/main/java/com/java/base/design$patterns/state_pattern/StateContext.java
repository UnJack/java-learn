package com.java.base.design$patterns.state_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 下午2:53
 */
public class StateContext {
    private State currentState;

    public StateContext(){
        currentState = new Poor();
    }

    public void changeState(State newState){
        this.currentState = newState;
    }

    public void saySomething(){
        this.currentState.saySomething(this);
    }
}