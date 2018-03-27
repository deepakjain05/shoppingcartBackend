package com.deepak.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepak.shoppingcart.dao.ProductDAO;
import com.deepak.shoppingcart.domain.Product;

public class ProductDaoTestCase {

	@Autowired
	private static  AnnotationConfigApplicationContext context;
	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static Product product;

	@BeforeClass
	public static void init( ) 
	{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.deepak");
	context.refresh();
	productDAO=(ProductDAO)context.getBean("productDAO");
	product=(Product)context.getBean("product");
	
	}
	 @Test
	 public void saveProductTestCase()
	 {
			product=new Product();
			product.setId("Denim-003");
			product.setName("Denim Black");
			product.setDescription("This is Denim trousers products");
			product.setCategoryId("Trousers-001	");
			product.setPrice(3000);
			 boolean status =productDAO.save(product);
			 
			  assertEquals("save Product testcase",true,status);
			 
		
	 }
	 @Test
	 public void updateProductTestCase()
	 {
		 product.setId("ONEPLUS");
		 product.setName("Oneplus 3");
		product.setDescription("This  is Oneplus product ");
		
		boolean status=productDAO.update(product);
		assertEquals("update Product testcase", true,status);
		
	 }
	 @Test
		public void getProductSuccessTestCase()
		{
			
		product= productDAO.get("OnePlus 3");
		
		assertNotNull("get Product test case", product);
		}
		
		@Test
		public void getProductFailureTestCase()
		{
			
		product= productDAO.get("ONEPLUS");
		
		assertNull("get Product test case", product);
		}
		@Test
		public void deleteProductSuccessTestCase()
		{
		boolean status =	productDAO.delete("OnePlus 3");
		assertEquals("delete Product succss test case" , true, status);
		
		}
		
		@Test
		public void deleteProductFailureTestCase()
		{
		boolean status =	productDAO.delete("ONEPLUS");
		assertEquals("delete Product failure test case" , false, status);
		
		}
		
		@Test
		public void getAllProductTestCase()
		{
			List<Product> Products= productDAO.list();
			assertEquals("get all Products", 3, Products.size());
		}
		
		
		
}
