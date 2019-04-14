package com.java.base.design$patterns.abstractFactory_pattern;

/**
 * Created by JianJie on 2017/3/15.
 */
public class test {
    public static void main(String[] args) {
        FactoryCar carFactory = new FactoryBMW();
        CarBMW bmwCar = (CarBMW) carFactory.createCar();
        bmwCar.start();
    }
}
