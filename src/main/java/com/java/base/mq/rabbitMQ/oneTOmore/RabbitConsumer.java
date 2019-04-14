package com.java.base.mq.rabbitMQ.oneTOmore;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by jianjie on 2017/8/1.
 */
public class RabbitConsumer {
    private static final String QUEUE_NAME = "one_TO_more";

    public static void main(String[] args) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost");
            Connection connection = connectionFactory.newConnection();
            final Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("[*]等待消息。");

            //每次从队列获取的数量
            channel.basicQos(10);

            final Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("[x]Received '" + message + "'");
                    try {
                        doWork(message);
                    } finally {
                        System.out.println("[x]Done");
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            };
            //消息消费完成确认
            //生产者只要发送信息就会从内存中删除
            boolean autoAck = true;
            channel.basicConsume(QUEUE_NAME, autoAck, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '。') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread();//中断();
                }
            }
        }
    }
}
