package com.deepak.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepak.shoppingcart.dao.UserDAO;
import com.deepak.shoppingcart.domain.User;

public class UserDaoTestCase {
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User user;

	@BeforeClass
	public static void init( ) 
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.deepak");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		user =(User)context.getBean("user");
	
	}
	 @Test
	 public void saveUserTestCase()
	 {
			user=new User();
			 user.setEmailID("prakash@gmail.com");
			 user.setMobile("9869218316");
			 user.setName("Prakash");
			 user.setPwd("prakash@12");
			 
			 boolean status =userDAO.save(user);
			 
			  assertEquals("save user testcase",true,status);
			 
		
	 }
	 @Test
	 public void updateUserTestCase()
	 {
		
		user.setEmailID("Suyash@gmail.com");
		user.setMobile("55555555");
		 user.setName("Suyash");
		 user.setPwd("suyash@123");
				
		
		boolean status=userDAO.update(user);
		assertEquals("update user testcase", true,status);
		
	 }
	 @Test
		public void getUserSuccessTestCase()
		{
			
		user= userDAO.get("pratikart@gmail.com");
		
		assertNotNull("get user test case", user);
		}
		
		@Test
		public void getUserFailureTestCase()
		{
			
		user= userDAO.get("pratikart@gmail.com");
		
		assertNull("get user test case", user);
		}
		@Test
		public void deleteUserSuccessTestCase()
		{
		boolean status =	userDAO.delete("deepkjai@gmail.com");
		assertEquals("delete user succss test case" , true, status);
		
		}
		
		@Test
		public void deleteUserFailureTestCase()
		{
		boolean status =	userDAO.delete("deepkjai@gmail.com");
		assertEquals("delete user failure test case" , false, status);
		
		}
		
		@Test
		public void getAllUserTestCase()
		{
			List<User> users= userDAO.list();
			assertEquals("get all users", 3, users.size());
		}
		
		@Test
		public void validateCredentialsTestCase()
		{
			user=userDAO.validate("pratikart@gmail.com", "pratik@12");
			assertNotNull("validate test case", user);
		}
		
		
}
