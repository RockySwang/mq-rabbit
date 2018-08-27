package com.example.demo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.producter.HelloSender;

/**
 * @author Swang1
 * Desc: 编写测试。 User实体我就不放了。记得进行序列化！
**/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTestApplicationTests {

	@Autowired
	private HelloSender helloSender;
	
	@Test
	public void hello() throws Exception{
		helloSender.send();
	}
	
	@Test
	public void helloSender() throws Exception{
		User user = new User();
		user.setName("乔多");
		user.setRoles(new ArrayList<String>());
		helloSender.sendObj(user);
	}
}
