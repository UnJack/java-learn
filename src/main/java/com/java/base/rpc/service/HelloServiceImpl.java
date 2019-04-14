package com.java.base.rpc.service;

import org.springframework.stereotype.Service;

/**
 * User: jianjie
 * Date: 16-5-3 上午11:14
 */
@Service("helloServiceImpl")
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }

}

