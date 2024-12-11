package org.learn.design.strategy_pattern;

/**
 * User: jimjian
 * Date: 16-3-23 下午3:47
 */
public class Situation {
    private Strategy strategy;

    public Situation(Strategy strategy){
        this.strategy = strategy;
    }

    public void handleByPolice(int speed){
        this.strategy.processSpeeding(speed);
    }
}