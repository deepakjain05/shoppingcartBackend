package com.deepak.shoppingcart.daoImpl;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.deepak.shoppingcart.dao.UserDAO;
import com.deepak.shoppingcart.domain.User;
@Transactional
@Repository("userDAO")


public class UserDAOImpl  implements UserDAO{
	
	@Autowired
	
	private SessionFactory sessionFactory ;
	

	public boolean save(User user) {
		
	
		try {
			user.setRole('C');
			user.setRegisteredDate(new Date(System.currentTimeMillis())+ "");
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		}

	public boolean update(User user) {
		
		try {
			
			user.setRole('C');
			//user.setRegisteredDate(new Date(System.currentTimeMillis())+ "");
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false ;
		}
	
		
		
	}
	
	public User get(String emailID) {
		
		return sessionFactory.getCurrentSession().load(User.class, emailID);

	}

	public boolean delete(String emailID) {
		
		try {
			User user=new User();
			user=get(emailID);
			if(user ==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);



			
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public List<User> list() {
	
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailID, String password) {
		
		
		return(User)sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(Restrictions.eq("emailID",emailID))
		.add(Restrictions.eq("pwd",password )).uniqueResult();
		
	}

}
