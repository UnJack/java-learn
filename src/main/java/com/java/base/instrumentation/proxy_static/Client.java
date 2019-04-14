package com.java.base.instrumentation.proxy_static;

public class Client {
    public static void main(String[] args) {
        Subject proxy = SubjectStaticFactory.getInstance();
        proxy.dealTask("DBQueryTask");
    }
}