package com.vk.inviteweb.datalayer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vk.inviteweb.datalayer.model.Event;

public class EventDaoImpl {
	
	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public Event save(Event event) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			session.save(event);
			tx.commit();
			System.out.println("Event save successfully");
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
			return event;
		else
			return null;
	}
	
	public List<Event> getList() {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Event> list=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			Criteria crt=session.createCriteria(Event.class);
			list=crt.list();
			System.out.println("Event save successfully");
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
			return list;
		else
			return null;
	}

}
