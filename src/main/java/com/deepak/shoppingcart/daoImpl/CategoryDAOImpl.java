package com.deepak.shoppingcart.daoImpl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepak.shoppingcart.dao.CategoryDAO;
import com.deepak.shoppingcart.domain.Category;
@Transactional
@Repository("categoryDAO")


public class CategoryDAOImpl  implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public boolean save(Category category) {
		
	
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		}

	public boolean update(Category category) {
		
		try {
			
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false ;
		}
	
		
		
	}
	
	public Category get(String id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, id);

	}

	public boolean delete(String id) {
		
		try {
			Category category=new Category();
			category=get(id);
			if(category ==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(category);



			
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public List<Category> list() {
	
		return (List<Category>)sessionFactory.getCurrentSession()
				.createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	
}
