package hibernate.ex;

import instavans.models.Job;
import instavans.models.Porter;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vk.inviteweb.datalayer.dao.UserManager;

import dao.JobDao;
import dao.PorterDao;

class MainClass {
	
	@Autowired
	private static UserManager userManager;

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException{
	      Porter porter=new Porter();
	      PorterDao porterDao=new PorterDao();
	      porterDao.save(porter);
	      JobDao jobDao=new JobDao();
	      jobDao.save(new Job());
	      ObjectMapper mapper=new ObjectMapper();
	      System.out.println(mapper.writeValueAsString(porter));
	}
}
