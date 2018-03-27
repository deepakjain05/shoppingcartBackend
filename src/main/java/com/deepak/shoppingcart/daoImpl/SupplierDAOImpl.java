package com.deepak.shoppingcart.daoImpl;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepak.shoppingcart.dao.SupplierDAO;
import com.deepak.shoppingcart.domain.Supplier;
@Transactional
@Repository("supplierDAO")


public class SupplierDAOImpl  implements SupplierDAO{
	
	@Autowired
	
	private SessionFactory sessionFactory ;
	

	public boolean save(Supplier supplier) {
		
	
		try {
			
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		}

	public boolean update(Supplier supplier) {
		
		try {
			
			
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false ;
		}
	
		
		
	}
	
	public Supplier get(String id) {
		
		return sessionFactory.getCurrentSession().load(Supplier.class, id);

	}

	public boolean delete(String id) {
		
		try {
			Supplier supplier=new Supplier();
			supplier=get(id);
			if(supplier ==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(supplier);



			
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public List<Supplier> list() {
	
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	
}
