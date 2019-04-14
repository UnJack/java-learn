package com.java.base.design$patterns.strategy_pattern;

/**
 * User: jianjie
 * Date: 16-3-23 下午3:47
 */
public class HardPolice implements Strategy{
    @Override
    public void processSpeeding(int speed) {
        System.out.println("Your speed is "+ speed+ ", and should get a ticket!");
    }
}