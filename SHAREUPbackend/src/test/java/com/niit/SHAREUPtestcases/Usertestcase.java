package com.niit.SHAREUPtestcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.UserDao;
import com.niit.model.User;


public class Usertestcase
{
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDao userDao;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		userDao =  (UserDao) context.getBean("userDao");
		
			
	}
	
	@Test
	public void createUserTestCase()
	{
		User user=new User();
		
		user.setEmail("DEVASENA@abc.com");
		user.setPassword("devasena");
		user.setFirstname("L");
		user.setLastname("D");
		user.setPhonenumber("095836978");
		user.setRole("ALUMNI");
		
		userDao.registration(user);
		assertEquals(user.getEmail(),user.getEmail());
	}
		


	}
	