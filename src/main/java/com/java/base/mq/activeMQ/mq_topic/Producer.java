package com.java.base.mq.activeMQ.mq_topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.UUID;

/**
 * User: jianjie
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
            connectionFactory.setUseAsyncSend(true);
            connection = connectionFactory.createConnection();
            connection.setClientID("TOPIC_PRODUCER");
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("ACTIVE.MQ.TEST.TOPIC");
            producer = session.createProducer(destination);
//            Message保存方式有2种
//            PERSISTENT：保存到磁盘，consumer消费之后，message被删除。
//            NON_PERSISTENT：保存到内存，消费之后message被清除。
//            注意：堆积的消息太多可能导致内存溢出。
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
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
            TextMessage message = session.createTextMessage("ActiveMq send" + UUID.randomUUID().toString());
            // 发送消息到目的地方
            System.out.println("发送消息：" + message.getText());
            producer.send(message);
        }
    }

}
