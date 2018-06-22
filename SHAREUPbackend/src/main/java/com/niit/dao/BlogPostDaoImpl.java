package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.BlogPost;
@Repository("blogpostDao")
@Transactional
public class BlogPostDaoImpl implements BlogPostDao {
   @Autowired
	private SessionFactory sessionFactory;
	public void saveBlogPost(BlogPost blogpost) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogpost);
	}
	public List<BlogPost> approvedBlogs() {
		Session session=sessionFactory.getCurrentSession();
	    
		Query query=session.createQuery("from BlogPost where approved=true");
		return query.list();//List of Blogposts which are approved
		
	}
	public List<BlogPost> blogsWaitingForApproval() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where approved=false");
		return query.list();//List of BlogPost objects which are not approved
	}
	public BlogPost getBlogPost(int id) {
		Session session=sessionFactory.getCurrentSession();
		BlogPost blogPost=(BlogPost)session.get(BlogPost.class,id);
		return blogPost;
	}

}
