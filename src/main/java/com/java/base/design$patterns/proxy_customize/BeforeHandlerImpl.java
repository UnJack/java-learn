package com.java.base.design$patterns.proxy_customize;

import java.lang.reflect.Method;

/**
 * User: jianjie
 * Date: 16-4-27 上午11:40
 */
public class BeforeHandlerImpl extends BeforeHandler {

    @Override
    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("before....");
    }
}
