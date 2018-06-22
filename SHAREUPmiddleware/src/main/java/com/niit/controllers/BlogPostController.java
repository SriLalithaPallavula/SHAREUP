package com.niit.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogPostDao;
import com.niit.dao.UserDao;
import com.niit.model.BlogPost;
import com.niit.model.ErrorClazz;
import com.niit.model.User;

@RestController
public class BlogPostController {
	@Autowired
	private BlogPostDao blogPostDao;
	@Autowired
	private UserDao userDao;
	//(blogTitle:'Introduction to DBMS'/'blogContent.............')
    @RequestMapping(value="/addblogpost",method=RequestMethod.POST)
	public ResponseEntity<?> saveblogPost(HttpSession session,@RequestBody BlogPost blogPost){//Authentication and data
		//check for authentication
    	String email=(String)session.getAttribute("email");
    	if(email==null){
    		ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
     new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);//2nd callback fun
    	}
    	
    	blogPost.setPostedOn(new Date());
    	//postedBy-author, logged in user
    	User postedBy=userDao.getUser(email);//user is postedBy, user is an author of the blogPost 
    	blogPost.setPostedBy(postedBy);
    	blogPostDao.saveBlogPost(blogPost);
    	return new ResponseEntity<BlogPost>(blogPost,HttpStatus.OK);
	}
    @RequestMapping(value="/blogsapproved",method=RequestMethod.GET)
    public ResponseEntity<?>getBlogsApproved(HttpSession session){
    	//check for authentication
    	String email=(String)session.getAttribute("email");
    	if(email==null){
    		ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
     return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
    	
    }
    	List<BlogPost>blogsApproved=blogPostDao.approvedBlogs();
    	return new ResponseEntity<List<BlogPost>>(blogsApproved,HttpStatus.OK);
    }
    @RequestMapping(value="/blogswaitingforapproval",method=RequestMethod.GET)
    public ResponseEntity<?>getBlogsWaitingForApproval(HttpSession session){
    	//check for authentication
    	String email=(String)session.getAttribute("email");
    	if(email==null){
    		ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
     return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
    }
    	//check for authorization
    User user=userDao.getUser(email);
    if(!(user.getRole().equals("ADMIN"))){
    	ErrorClazz errorClazz=new ErrorClazz(8,"Access Denied...");
    	return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
    }
    List<BlogPost> blogsWaitingForApproved=blogPostDao.blogsWaitingForApproval();
    return new ResponseEntity<List<BlogPost>>(blogsWaitingForApproved,HttpStatus.OK);
    }
    @RequestMapping(value="/getblogpost/{id}",method=RequestMethod.GET)
    public ResponseEntity<?>getBlogPost(@PathVariable int id,HttpSession session){
    	//check for authentication
    	String email=(String)session.getAttribute("email");
    	if(email==null){
    		ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access.. please login");
     return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
    }
    BlogPost blogPost=blogPostDao.getBlogPost(id);
    return new ResponseEntity<BlogPost>(blogPost,HttpStatus.OK);
}
}
