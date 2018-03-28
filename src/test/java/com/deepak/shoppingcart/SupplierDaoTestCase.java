package com.deepak.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepak.shoppingcart.dao.SupplierDAO;
import com.deepak.shoppingcart.domain.Supplier;


public class SupplierDaoTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;

	@BeforeClass
	public static void init( ) 
	{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.deepak");
	context.refresh();
	supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	
	}
	 @Test
	 public void savesupplierTestCase()
	 {
		 	supplier=new Supplier();
			supplier.setId("Supplier-006");
			supplier.setName("Enterperises Mumbai");
			supplier.setAddress("Mumbai");
			 
			 boolean status =supplierDAO.save(supplier);
			 
			  assertEquals("save supplier testcase",true,status);
			 
		
	 }
	 @Test
	 public void updatesupplierTestCase()
	 {
		 supplier=new Supplier();
		supplier.setId("Supplier-006");
		supplier.setName("new  Enterprises");
		supplier.setAddress(" Mumbai");
		
		boolean status=supplierDAO.update(supplier);
		assertEquals("update supplier testcase", true,status);
		
	 }
	 @Test
		public void getsupplierSuccessTestCase()
		{
			
		supplier= supplierDAO.get("Supplier-004");
		
		assertNotNull("get supplier test case", supplier);
		}
		
		@Test
		public void getsupplierFailureTestCase()
		{
			
		supplier= supplierDAO.get("Supplier-004");
		
		assertNull("get supplier test case", supplier);
		}
		@Test
		public void deletesupplierSuccessTestCase()
		{
		boolean status =supplierDAO.delete("Supplier-001");
		assertEquals("delete supplier succss test case" , true, status);
		
		}
		
		@Test
		public void deletesupplierFailureTestCase()
		{
		boolean status =	supplierDAO.delete("Supplier-001");
		assertEquals("delete supplier failure test case" , false, status);
		
		}
		
		@Test
		public void getAllsupplierTestCase()
		{
			List<Supplier> suppliers= supplierDAO.list();
			assertEquals("get all suppliers", 3, suppliers.size());
		}
		
		
		
		
}
