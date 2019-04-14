package com.java.base.mq.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSProducer {

	/**
	 * @param args
	 */
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
	//private static final String BROKERURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int SENDNUM=10;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		Destination destination;
		MessageProducer messageProducer;
		
		
		connectionFactory=new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, "failover:(tcp://localhost:61616,tcp://localhost:61617)");
		
		/*connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://localhost:61616");*/

		
		try {
			connection=connectionFactory.createConnection();
			connection.start();
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			destination=session.createQueue("FirstQueue1");
			messageProducer=session.createProducer(destination);
			sendMessage(session, messageProducer);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (connection!=null) {
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	public static void sendMessage(Session session, MessageProducer messageProducer)throws Exception {
		for (int i = 0; i < JMSProducer.SENDNUM; i++) {
			TextMessage textMessage=session.createTextMessage("ActiveMQ发送的消息"+i);
			System.out.println("activeMQ发送消息："+i);
			messageProducer.send(textMessage);
			
		}
	}

}
