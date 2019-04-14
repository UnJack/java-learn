package com.java.base.design$patterns.abstractFactory_pattern;

/**
 * Created by JianJie on 2017/3/15.
 */
public class FactoryToyota implements FactoryCar{
    @Override
    public Car createCar() {
        return new CarToyota();
    }
}
