package com.java.base.jvm.javassit;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args, Instrumentation inst) {
        System.out.println("=========premain start========");
        System.out.println(args);
        inst.addTransformer(new Transformer());
    }
}
