package org.learn.design.strategy_pattern;

/**
 * User: jimjian
 * Date: 16-3-23 下午3:47
 */
public class HardPolice implements Strategy{
    @Override
    public void processSpeeding(int speed) {
        System.out.println("Your speed is "+ speed+ ", and should get a ticket!");
    }
}