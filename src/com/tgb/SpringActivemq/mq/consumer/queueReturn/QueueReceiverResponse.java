
package com.tgb.SpringActivemq.mq.consumer.queueReturn;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description  队列消息监听器
 * 
 */
@Component
public class QueueReceiverResponse implements SessionAwareMessageListener<TextMessage> {
	@Autowired  
    @Qualifier("sessionAwareQueueDestination")
	private Destination destination;
	
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		try {
			System.out.println("QueueReceiverResponse接收到消息:"+message.getText());
			MessageProducer producer = session.createProducer(destination);
			Message textMessage = session.createTextMessage("我收到消息了，这是我的返回");
			producer.send(textMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
