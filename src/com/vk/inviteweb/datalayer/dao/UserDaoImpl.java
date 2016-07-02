package com.vk.inviteweb.datalayer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.vk.inviteweb.datalayer.model.User;

//@Repository
public class UserDaoImpl implements UserDao{

	//@Autowired
	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public User save(User user) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			System.out.println("User save successfully");
			session.save(user);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			isSuccess=false;
			System.out.println("Unsucess "+e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
		if(isSuccess)
			return user;
		else
			return null;
	}
	
	public User get(String userId) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		User user=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			System.out.println("User save successfully");
			user=(User)session.get(User.class, userId);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			isSuccess=false;
			System.out.println("Unsucess "+e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
		if(isSuccess)
			return user;
		else
			return null;
	}
	
	public User checkLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		User user=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			System.out.println("User save successfully");
			Criteria cr = session.createCriteria(User.class);
			Map map =new HashMap<String,String>();
			map.put("userId", userName);
			map.put("password", passWord);
			//cr.add(Restrictions.allEq(map));
			cr.add(Restrictions.eq("email", userName));
			cr.add(Restrictions.eq("password", passWord));
			List list=cr.list();
			System.out.println(list.size());
			if(list!=null && list.size()>0)
				user=(User)list.get(0);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			isSuccess=false;
			System.out.println("Unsucess "+e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
		if(isSuccess)
			return user;
		else
			return null;
	}
	

}
