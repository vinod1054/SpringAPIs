package dao;

import instavans.models.Job;
import instavans.models.Porter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import locationutils.CalculateDistanceSendGcm;
import locationutils.LocationUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JobDao {

private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	
	public Job save(Job job) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(job);
			tx.commit();
			new CalculateDistanceSendGcm(job).run();
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
	
	public List<Job> getJobs() {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Job> listJobs=new ArrayList<Job>();
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			System.out.println("User save successfully");
			Criteria crt=session.createCriteria(Job.class);
			listJobs=crt.list();
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
			return listJobs;
		else
			return null;
	}
	
	
	public List<Job> getJobs(final Porter ptr) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Job> listJobs=new ArrayList<Job>();
		boolean isSuccess=true;
		try{
			System.out.println("Opening session");
			session=sessionFactory.openSession();
			System.out.println("Opening session - success");
			tx = session.beginTransaction();
			System.out.println("User save successfully");
			Criteria crt=session.createCriteria(Job.class);
			listJobs=crt.list();
			Collections.sort(listJobs, new Comparator<Job>() {

				public int compare(Job job1, Job job2) {
					// TODO Auto-generated method stub
					double dist1=LocationUtil.distance(ptr.getLat(), job1.getLat(), ptr.getLang(), job1.getLang(), 0, 0);
					double dist2=LocationUtil.distance(ptr.getLat(), job2.getLat(), ptr.getLang(), job2.getLang(), 0, 0);
					return (int) (dist1-dist2);
				}
			});
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
			return listJobs;
		else
			return null;
	}
	
	
	
	
	
}
