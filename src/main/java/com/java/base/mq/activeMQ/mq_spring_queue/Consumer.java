package com.java.base.mq.activeMQ.mq_spring_queue;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
public class Consumer {

    private JmsTemplate jmsTemplate;

    public Consumer() {
    }

    public String receiveMessage() {
        String str = "";
        MapMessage message = (MapMessage) jmsTemplate.receive();
        try {
            str = message.getString("lastName");
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
        return str;
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
