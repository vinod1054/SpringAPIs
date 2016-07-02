package dao;

import gcm.SendGcm;
import instavans.models.Job;
import instavans.models.Porter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class PorterDao {
	
	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	
	public Porter save(Porter porter) {
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
			session.save(porter);
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
			return porter;
		else
			return null;
	}
	
	
	public Porter isUserExist(Porter porter) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Porter.class);
			crt.add(Restrictions.eq("id", porter.getId()));
			crt.add(Restrictions.eq("mobileNumber", porter.getMobileNumber()));
			List<Porter> list=crt.list();
			if(list!=null && list.size()>0)
				porter=list.get(0);
			else
				porter=null;
			System.out.println("User save successfully");
			session.save(porter);
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
			return porter;
		else
			return null;
	}
	
	
	
	public List<Porter> getPorters(String jobId){
		List<Porter> list=new ArrayList<Porter>();
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Porter.class);
			list=crt.list();
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
			return list;
		else
			return null;
}
	
	public Porter getPorter(String porterId){
		List<Porter> list=new ArrayList<Porter>();
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Porter.class);
			crt.add(Restrictions.eq("id", Integer.parseInt(porterId)));
			list=crt.list();
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
			return list.get(0);
		else
			return null;
}
	
	
	
	public Porter updateGcm(int porterId,String gcmid){
		org.hibernate.Transaction tx=null;
		Session session=null;
		Porter porter=new Porter();
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Porter.class);
			crt.add(Restrictions.eq("id", porterId));
			porter=(Porter) crt.list().get(0);
			porter.setGcmid(gcmid);
			session.update(porter);
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
		if(isSuccess){
			SendGcm.send(porter.getGcmid(),"Gcm Updated");
			return porter;
			}
		else
			return null;
}
	
	public Porter updateLocation(int porterId,double lat,double lang){
		org.hibernate.Transaction tx=null;
		Session session=null;
		Porter porter=new Porter();
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Porter.class);
			crt.add(Restrictions.eq("id", porterId));
			porter=(Porter) crt.list().get(0);
			porter.setLat(lat);
			porter.setLang(lang);
			session.update(porter);
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
		if(isSuccess){
			SendGcm.send(porter.getGcmid(),"Gcm Updated");
			return porter;
			}
		else
			return null;
}
	
	
	public List<Porter> getAllPorters(){
		List<Porter> list=new ArrayList<Porter>();
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Porter.class);
			list=crt.list();
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
			return list;
		else
			return null;
}
	
	
	

}
