package api;

import instavans.models.Job;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vk.inviteweb.datalayer.dao.EventDaoImpl;
import com.vk.inviteweb.datalayer.model.Event;

import dao.JobDao;



@Controller
@RequestMapping("/instaapi")
public class CreatePorterJob {
	ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="/getjobs/",method = RequestMethod.GET)
	   public String getJobs(ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  model.addAttribute("message", "Hello");
		  return "api";
	   }
	
	
	@RequestMapping(value="/createjob/",method = RequestMethod.POST)
	   public String createJob(@RequestParam("data") String data,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  System.out.println("Create Job call");
		  System.out.println("Create Job Data :: "+data);
		  JSONObject json = new JSONObject(data);
		  Job job = mapper.readValue(data,Job.class);
		  JobDao jobDao=new JobDao();
		  jobDao.save(job);
		  model.addAttribute("message", new JSONObject().put("data",mapper.writeValueAsString(job)));
		  return "api";
	   }
	
	@RequestMapping(value="/createjob1/",method = RequestMethod.POST)
	   public String createJob1(@RequestParam("data") String data,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  System.out.println("Create Job call");
		  System.out.println("Create Job Data :: "+data);
		  JSONObject json = new JSONObject(data);
		  Job job = mapper.readValue(data,Job.class);
		  JobDao jobDao=new JobDao();
		  jobDao.save(job);
		  model.addAttribute("message", "Hole");
		  return "api";
	   }
	

}
