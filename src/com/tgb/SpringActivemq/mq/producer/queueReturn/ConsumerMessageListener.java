package com.tgb.SpringActivemq.mq.producer.queueReturn;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 
 * @author liang
 * @description  队列消息生产者，发送消息到队列
 * 
 */
public class ConsumerMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("ConsumerMessageListener接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
