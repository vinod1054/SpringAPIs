package dao;

import instavans.models.Job_Porter;
import instavans.models.Porter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class JobPorterDao {
	
	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public Job_Porter save(Job_Porter job) {
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
			session.saveOrUpdate(job);
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
			return job;
		else
			return null;
	}
	
	
	public List<Porter> getPorters(String jobid) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Job_Porter> list=new ArrayList<Job_Porter>();
		List<Porter> listp=new ArrayList<Porter>();
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			System.out.println("User save successfully");
			Criteria crt=session.createCriteria(Job_Porter.class);
			crt.add(Restrictions.eq("jobId", Integer.parseInt(jobid)));
			crt.add(Restrictions.eq("status", 2));
			list=crt.list();
			Iterator<Job_Porter> itr=list.iterator();
			PorterDao porterDao=new PorterDao();
			while(itr.hasNext()){
				Job_Porter jp=itr.next();
				listp.add(porterDao.getPorter(jp.getPorterId()+""));
			}
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
			return listp;
		else
			return null;
	}
	
	

}
