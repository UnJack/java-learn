package com.java.base.mq.activeMQ.mq_spring_queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mq/spring_mq_queue.xml");
        Consumer receiver = (Consumer) context.getBean("receiver");
        System.out.print(receiver.receiveMessage());
    }
}