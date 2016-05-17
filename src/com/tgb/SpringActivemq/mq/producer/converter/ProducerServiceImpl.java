package com.tgb.SpringActivemq.mq.producer.converter;

import java.io.Serializable;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerServiceImpl implements ProducerService {

//	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(Destination destination, final Serializable obj) {
		// 未使用MessageConverter的情况
		/*jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objMessage = session.createObjectMessage(obj);
				return objMessage;
			}
		});*/
		// 使用MessageConverter的情况
		jmsTemplate.convertAndSend(destination, obj);
	}

}