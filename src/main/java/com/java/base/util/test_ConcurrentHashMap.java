package com.java.base.util;

import org.jboss.netty.util.internal.ConcurrentHashMap;

import java.util.Map;

/**
 * User: jimjian
 * Date 2018/11/17 11:15 AM
 */
public class test_ConcurrentHashMap {
    public static void main(String[] args) {
        Map map = new ConcurrentHashMap();
        map.put("a1", "1");
        map.put("a2", "2");
        map.put("a3", "3");
        map.put("a4", "4");
    }
}
