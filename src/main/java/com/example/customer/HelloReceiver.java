package com.example.customer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

/**
 * @author Swang1
 * Desc: 消费者，接收消息。注意queues中的值表示你想接受哪个队列中的消息。
**/
@Component
public class HelloReceiver {

	@RabbitListener(queues = "date")
	public void processDate(String date){
		System.out.println("Receiver =================: " + date);
	}
	
	@RabbitListener(queues = "object")
	public void processObj(User user){
		System.out.println("Receiver ==================: " + user);
        System.out.println("Receiver ==================: " + user.getName());
        //System.out.println("Receiver ==================: " + user.getSex());
	}
}
