package com.artiope.springbootTest.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.artiope.springbootmaven.dao.mongo.UserRepository;
import com.artiope.springbootmaven.entity.mongo.User;
import com.artiope.springbootmaven.SpringBootMaven;


////SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)

////指定我们SpringBoot工程的Application启动类
@SpringApplicationConfiguration(classes = SpringBootMaven.class)

///由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class UserRepositoryTest {

	 @Resource
	    private UserRepository userRepository;
	 
       //@SuppressWarnings("deprecation")
	@Test
	   public void testUserService() {
		  User user = new User();
		  user.setId("test1234567");
		  user.setName("mongo测试");
		  user.setPwd("784405869");
		  user.setSalary("1000000");
		  user.setSex("男");
		  userRepository.insert(user);
		
		  User user2 = userRepository.findOne("test123456");
		  System.out.println(user2);
	   }
}
