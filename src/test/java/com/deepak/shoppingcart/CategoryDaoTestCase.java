package com.deepak.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepak.shoppingcart.dao.CategoryDAO;
import com.deepak.shoppingcart.domain.Category;

public class CategoryDaoTestCase {
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.deepak");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category=(Category)context.getBean("category");
	}
	 @Test
	 public void saveCategoryTestCase()
	 {
			 category.setId("Shirt-001");
			 category.setName("Shirt");
			 category.setDescription("This is Shirt Category");
			 
			 boolean status =categoryDAO.save(category);
			 
			  assertEquals("save category testcase",true,status);
			 
		
	 }
	 @Test
	 public void updateCategoryTestCase()
	 {
		
		category.setId(" jeans ");
		category.setDescription("This is new  jeans Category");
		 category.setName("Jeans");
		 
				
		
		boolean status=categoryDAO.update(category);
		assertEquals("update category testcase", true,status);
		
	 }
	 @Test
		public void getCategorySuccessTestCase()
		{
			
		category= categoryDAO.get("Mob-001");
		
		assertNotNull("get category test case", category);
		}
		
		@Test
		public void getCategoryFailureTestCase()
		{
			
		category= categoryDAO.get("Mob-001");
		
		assertNull("get category test case", category);
		}
		@Test
		public void deleteCategorySuccessTestCase()
		{
		boolean status =categoryDAO.delete("jeans  ");
		assertEquals("delete category succss test case" , true, status);
		
		}
		
		@Test
		public void deleteCategoryFailureTestCase()
		{
		boolean status =	categoryDAO.delete("Mob-001");
		assertEquals("delete category failure test case" , false, status);
		
		}
		
		@Test
		public void getAllCategoryTestCase()
		{
			List<Category> categorys= categoryDAO.list();
			assertEquals("get all categories", 3, categorys.size());
		}
		
		
		
}
