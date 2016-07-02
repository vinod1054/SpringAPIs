package fdao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import instavans.models.Comments;
import instavans.models.Place;
import locationutils.LocationUtil;

public class PlaceDao {
	
private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public void save(Place place) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		boolean isSuccess=true;
		try{
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			place.setVisitorsCount(1);
			place.setOpen(true);
			session.save(place);
			tx.commit();
		}
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			System.out.println(e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
	}
	
	public List<Place> getPlaces(final double lat,final double lang) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Place> list = null;
		boolean isSuccess=true;
		try{
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Place.class);
			crt.add(Restrictions.eq("isOpen", true));
			list=crt.list();
			System.out.println(lat+" "+lang+" "+list.size());
			Collections.sort(list,new Comparator<Place>() {
				public int compare(Place place1, Place place2) {
					// TODO Auto-generated method stub
					double distance1=LocationUtil.distance(lat, place1.getLat(), lang, place1.getLang(), 0, 0);
					double distance2=LocationUtil.distance(lat, place2.getLat(), lang, place2.getLang(), 0, 0);
					return (int) (distance1-distance2);
				}
			});
			tx.commit();
			
		}
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			System.out.println(e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public List<Place> getPlaces(final String query) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Place> list = null;
		boolean isSuccess=true;
		try{
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Place.class);
			crt.add(Restrictions.like("name", "%"+query.toUpperCase()+"%"));
			list=crt.list();
			tx.commit();
			
		}
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			System.out.println(e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	
	public List<Place> addComment(long placeId,Comments comment) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Place> list = null;
		boolean isSuccess=true;
		try{
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Place.class);
			crt.add(Restrictions.eq("id", placeId));
			Place place =(Place)crt.list().get(0);
			place.setVisitorsCount(place.getVisitorsCount()+1);
			place.setRating((place.getRating()+comment.getRating())/place.getVisitorsCount());
			place.getComments().add(comment);
			session.update(place);
			tx.commit();
		}
		
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			System.out.println(e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public List<Place> isOpen(long placeId,boolean isOpen) {
		// TODO Auto-generated method stub
		org.hibernate.Transaction tx=null;
		Session session=null;
		List<Place> list = null;
		boolean isSuccess=true;
		try{
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria crt=session.createCriteria(Place.class);
			crt.add(Restrictions.eq("id", placeId));
			Place place =(Place)crt.list().get(0);
			place.setVisitorsCount(place.getVisitorsCount()+1);
			place.setOpen(isOpen);
			session.update(place);
			tx.commit();
		}
		
		catch(Exception e){
			if(tx!=null)
				tx.rollback();
			System.out.println(e.toString());
		}
		finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	

}
