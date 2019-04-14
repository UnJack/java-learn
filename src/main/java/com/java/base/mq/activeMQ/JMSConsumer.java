package com.java.base.mq.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
	//private static final String BROKERURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		Destination destination;
		MessageConsumer messageConsumer;
		
		connectionFactory=new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, "failover:(tcp://localhost:61616,tcp://localhost:61617)");
		try {
			connection=connectionFactory.createConnection();
			connection.start();
			session=connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
			destination=session.createQueue("FirstQueue1");
			messageConsumer=session.createConsumer(destination);
			while (true) {
				TextMessage textMessage=(TextMessage)messageConsumer.receive(50);
				
				if (textMessage!=null) {
					textMessage.acknowledge();
					System.out.println("收到的消息："+textMessage.getText());
					
				}
				else {
					break;
				}
				
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
