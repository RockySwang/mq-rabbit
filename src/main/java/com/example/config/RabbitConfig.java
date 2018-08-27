package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auth swang
 * Desc: First, configure a queue and name the queue
**/
@Configuration
public class RabbitConfig {

	@Bean
	public Queue dataQueue(){
		return new Queue("data");
	}
	
	@Bean
	public Queue objQueue(){
		return new Queue("object");
	}
}



