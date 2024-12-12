package cn.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by jimjian on 2017/4/6.
 */
public class PinpointBootStrap {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println(System.getProperty("java.class.path"));
    }
}
