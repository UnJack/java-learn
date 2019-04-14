package com.java.base.mq.activeMQ;

/**
 * User: jianjie
 * Date: 16-6-12 下午5:11
 */
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;


/**
 * <pre>
 *  1、先运行监听者,向jms server注册,让jms server知道有这个持久订阅者。类似于你向腾讯申请个QQ号码
 *
 *  2、启动jms server和持久订阅者(运行该类)。查看数据库可以发现activemq_acks中多了一条记录，
 *     也就是说activeMQ识别和接受了我们的持久订阅者
 *
 *  3、停止持久订阅者，启动生产者向MQ服务器发送持久消息和非持久消息。发现activemq_msgs中多持久消息
 *
 *  4、运行持久订阅者。发现持久消息和非持久消息都能接受到
 * </pre>
 *
 */
public class DurableSubscriberTest
{

    public static void main(String[] args) throws Exception
    {
        TopicConnection connection = getTopicConnection();
        Topic topic = getTopic(connection);

        // 创建持久订阅的时候,必须要设置client,否则会报错:
        // javax.jms.JMSException: You cannot create a durable subscriber
        // without specifying a unique clientID on a Connection

        // 如果clientID重复(已经存在相同id的活动连接),会报错
        // javax.jms.InvalidClientIDException: Broker: localhost - Client: 1
        // already connected from tcp://127.0.0.1:2758
        connection.setClientID("1");

        TopicSession session = connection.createTopicSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // 在同一个连接的ClientID下,持久订阅者的名称必须唯一
        // javax.jms.JMSException: Durable consumer is in use for client: 1 and
        // subscriptionName: 11

        // TopicSubscriber subscriber = session.createSubscriber(topic);
        TopicSubscriber subscriber = session.createDurableSubscriber(topic,
                "11");

        subscriber.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message msg)
            {
                try
                {
                    TextMessage textMsg = (TextMessage) msg;
                    System.out.println("DurableSubscriber get:"
                            + textMsg.getText());
                } catch (JMSException e)
                {
                    e.printStackTrace();
                }
            }
        });

        connection.start();// 一定要start
    }

    public static TopicConnection getTopicConnection() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        TopicConnection topicConnection=connectionFactory.createTopicConnection();
        topicConnection.setClientID("2213");
        topicConnection.start();
        return topicConnection;
    }

    public static Topic getTopic(TopicConnection topicConnection) throws JMSException {
        TopicSession session = topicConnection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
        return session.createTopic("aa");
    }
}
