package com.java.base.rpc.exception;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by jian.jie on 2016/12/15.
 */
public class AOPException implements ThrowsAdvice {

    public void afterThrowing(Exception e) {
        System.out.println("异常详细信息：　　　" + e);
    }
}
