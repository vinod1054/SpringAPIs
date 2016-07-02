package locationutils;

import gcm.SendGcm;
import instavans.models.Job;
import instavans.models.Job_Porter;
import instavans.models.Porter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import dao.JobPorterDao;
import dao.PorterDao;

public class CalculateDistanceSendGcm implements Runnable{

	PorterDao porterDao=new PorterDao();
	JobPorterDao jpo=new JobPorterDao();
	ObjectMapper mapper = new ObjectMapper();
	Job job;
	public CalculateDistanceSendGcm(Job job){
		this.job=job;
	}

	public void run() {
		System.out.println("Thread Fired");
		// TODO Auto-generated method stub
		List<Porter> list=porterDao.getAllPorters();
		Iterator< Porter> itr=list.iterator();
		int count=0;
		while(itr.hasNext() && count<job.getRequiredNumOfPorters()){
			Porter ptr=itr.next();
			double distance=LocationUtil.distance(ptr.getLat(), job.getLat(), ptr.getLang(), job.getLang(), 0, 0);
			if(distance/1000<=1)
				try {
					SendGcm.send(ptr.getGcmid(),mapper.writeValueAsString(job) );
					Job_Porter jobP=new Job_Porter();
					jobP.setJobId((int)job.getId());
					jobP.setPorterId(ptr.getId());
					jobP.setStatus(1);
					jpo.save(jobP);
					count++;
				} catch (JsonGenerationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	
	
}
