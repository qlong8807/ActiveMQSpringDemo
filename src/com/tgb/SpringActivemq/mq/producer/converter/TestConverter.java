package com.tgb.SpringActivemq.mq.producer.converter;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tgb.SpringActivemq.mq.entity.Email;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/amqConverter.xml")
public class TestConverter {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	@Qualifier("adapterQueue")
	private Destination destination;

	@Test  
	public void testObjectMessage() {  
	    Email email = new Email("zhangsan@xxx.com", "主题", "内容");  
	    producerService.sendMessage(destination, email);  
	} 
}
