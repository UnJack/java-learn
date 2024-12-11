package com.java.base.mq.activeMQ.mq_queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
/**
 * User: jimjian
 * Date: 16-4-20 下午4:26
 */
public class Producer {

    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = null;
        // 创建一个连接
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;
        try {
            connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            // 设置客户端连接标识
            connection.setClientID("Producer");
            // 启动
            connection.start();
            //
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("uquq");
            // 创建消息生产者
            producer = session.createProducer(destination);
//          JMS支持两种消息提交模式:
//            PERSISTENT.表示JSM provider持久保存消息，以保证消息不会因为JMS provider的失败而丢失。
//              保存到磁盘，consumer消费之后，message被删除。
//            NON_PERSISTENT.buyaoqiu JMS provider持久保存信息。
//              保存到内存，消费之后message被清除。注意：堆积的消息太多可能导致内存溢出。
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(session, producer);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable e) {
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer producer) throws Exception {
        for (int i = 1; i <= 5; i++) {
            TextMessage message = session.createTextMessage("ActiveMq 发送的消息21" + i);
            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            producer.send(message);
        }
    }

}
