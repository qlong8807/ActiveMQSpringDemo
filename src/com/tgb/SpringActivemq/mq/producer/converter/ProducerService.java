package com.tgb.SpringActivemq.mq.producer.converter;

import java.io.Serializable;

import javax.jms.Destination;

public interface ProducerService {
	public void sendMessage(Destination destination, final Serializable obj);
}
