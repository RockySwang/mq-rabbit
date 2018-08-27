package com.example.producter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

/**
 * @Auth swang
 * Desc: 生产者，发送消息。可以看下方法convertAndSend源码。
 * 默认使用的交换机类型是direct直连。
 * 交换机类型一共四种分别为direct, topic, headers, fanout以后再说。
**/
@Component
public class HelloSender {

	@Autowired
	private Queue dataQueue;
	
	@Autowired
	private Queue objQueue;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(){        
        String context = "now date ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend(dataQueue.getName(), context);
	}
	
	public void sendObj(User user){
		System.out.println("Sender : " + user);
		rabbitTemplate.convertAndSend(objQueue.getName(), user);
	}
}
