package com.java.base.rpc.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
/**
 * User: jianjie
 * Date: 16-3-10 Time: 上午10:31
 */
public class ServerTest {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/spring_dubbo_server.xml" );
        context.start();
        System.out.println("服务启动成功，按任意键退出。");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
