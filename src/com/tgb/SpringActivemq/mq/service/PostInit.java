package com.tgb.SpringActivemq.mq.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgb.SpringActivemq.mq.producer.queue.QueueSender;

@Component
public class PostInit{

	@Autowired
	private QueueSender queueSender;
	
	@PostConstruct
	public void onApplicationEvent() {
		queueSender.say("bean加载完成后执行。。。");
	}

}
