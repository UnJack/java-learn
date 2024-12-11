package com.java.base.mq.activeMQ;

/**
 * User: jimjian
 * Date: 16-6-12 下午5:00
 */

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 直接运行该程序和activeMQ,没有任何的消费者，然后观察持久化介质(我们使用了数据库)
 */
public class NoReceiverTest {
    private static TopicConnection connection = null;

    private static Topic topic = null;

    public static void main(String[] args) throws Exception {
        connection = getTopicConnection();
        sentPersistent();
        sentNonPersistent();
        connection.close();
    }

    public static TopicConnection getTopicConnection() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        TopicConnection topicConnection=connectionFactory.createTopicConnection();
        topicConnection.setClientID("2");
        topicConnection.start();
        return topicConnection;
    }



    public static void sentPersistent() throws Exception {
        TopicSession session = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
        TopicPublisher publihser = session.createPublisher(session.createTopic("aa"));
        publihser.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 0; i < 3; i++) {
            String text = "I am persistent message.order=" + i;
            TextMessage message = session.createTextMessage(text);
            message.setJMSPriority(i);
            publihser.publish(message);
        }

    }

    public static void sentNonPersistent() throws Exception {
        TopicSession session = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
        TopicPublisher publihser = session.createPublisher(session.createTopic("aa"));
        publihser.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        for (int i = 0; i < 3; i++) {
            String text = "non-persistent message.id=" + i;
            TextMessage message = session.createTextMessage(text);
            publihser.publish(message);
        }

    }

}
