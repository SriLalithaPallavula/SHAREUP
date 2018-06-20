package com.niit.SHAREUPtestcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogPostDao;
import com.niit.dao.JobDao;
import com.niit.model.BlogPost;
import com.niit.model.Job;

public class BlogPosttestcase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	 static BlogPostDao  blogpostDao;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
				blogpostDao =  (BlogPostDao) context.getBean("blogpostDao");
	}
	@Test
	public void test() {
		BlogPost blogpost=new BlogPost();

		blogpost.setBlogTitle("Introduction to DBMS");
		blogpost.setBlogContent("A database management system (DBMS) is system software for creating and managing databases.");
		
		blogpost.setPostedOn(new Date());
		
		blogpostDao.saveBlogPost(blogpost);
		
		assertEquals(blogpost.getId(),blogpost.getId());
			}

}
