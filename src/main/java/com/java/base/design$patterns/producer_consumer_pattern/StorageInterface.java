package com.java.base.design$patterns.producer_consumer_pattern;

/**
 * User: jianjie
 * Date: 16-3-22 下午5:43
 */
public interface StorageInterface {

    public void produce(int num);
    public void consume(int num);
}

