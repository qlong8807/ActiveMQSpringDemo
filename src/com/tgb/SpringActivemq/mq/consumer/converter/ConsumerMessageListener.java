package com.tgb.SpringActivemq.mq.consumer.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.jms.support.converter.MessageConverter;

import com.tgb.SpringActivemq.mq.entity.Email;

public class ConsumerMessageListener implements MessageListener {
	 
    private MessageConverter messageConverter;
    
    public void onMessage(Message message) {
        
        if (message instanceof ObjectMessage) {
            ObjectMessage objMessage = (ObjectMessage) message;
            try {
                /*Object obj = objMessage.getObject();
                Email email = (Email) obj;*/
                Email email = (Email) messageConverter.fromMessage(objMessage);
                System.out.println("接收到一个ObjectMessage，包含Email对象。");
                System.out.println(email);
            } catch (JMSException e) {
                e.printStackTrace();
            }
            
        }
    }
 
    public MessageConverter getMessageConverter() {
        return messageConverter;
    }
 
    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }
 
}
