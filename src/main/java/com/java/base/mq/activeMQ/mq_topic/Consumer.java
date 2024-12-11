package com.java.base.mq.activeMQ.mq_topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: jimjian
 * Date: 16-4-20 下午5:16
 */
public class Consumer implements Runnable {

    private String name;

    Consumer() {
    }

    Consumer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Topic topic;
        // 消费者，消息接收者
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            connection.setClientID("TOPIC_CONSUMER");
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            // 获取session
            topic = session.createTopic("ACTIVE.MQ.TEST.TOPIC");
            consumer = session.createDurableSubscriber(topic, "TOPIC_CONSUMER");
            while (true) {
                //设置接收者接收消息的时间，为了便于测试，这里谁定为100s
                TextMessage message = (TextMessage) consumer.receive(10000);
                if (null != message) {
                    System.out.println(this.name + " 收到消息" + message.getText());
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Consumer c1 = new Consumer("Consumer1");
        Consumer c2 = new Consumer("Consumer2");
        Consumer c3 = new Consumer("Consumer3");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();
    }
}