package com.java.base.design$patterns.strategy_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 下午3:46
 */
public class NicePolice implements Strategy{
    @Override
    public void processSpeeding(int speed) {
        System.out.println("This is your first time, be sure don't do it again!");
    }
}
