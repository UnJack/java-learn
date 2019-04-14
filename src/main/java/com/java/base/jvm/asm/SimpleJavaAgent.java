package com.java.base.jvm.asm;

import java.lang.instrument.Instrumentation;

/**
 * mvn package
 * http://jiangbo.me/blog/2012/02/21/java-lang-instrument/
 * Created by persiacai on 2016/3/31.
 */
public class SimpleJavaAgent {
    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("Premain");
        System.out.println("Number of classes loaded: "+instrumentation.getAllLoadedClasses().length);
        instrumentation.addTransformer(new DemoTransformer());
    }
}
