package instavans.apis;

import instavans.models.Job;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.JobDao;



@Controller
@RequestMapping("/instaapi")
public class CreatePorterJob {
	ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="/createjob/",method = RequestMethod.POST)
	   public String createJob(@RequestParam("data") String data,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  System.out.println("Create Job call");
		  System.out.println("Create Job Data :: "+data);
		  JSONObject json = new JSONObject(data);
		  Job job = mapper.readValue(data,Job.class);
		  JobDao jobDao=new JobDao();
		  jobDao.save(job);
		  model.addAttribute("message", new JSONObject().put("data",mapper.writeValueAsString(job)));
		  return "instaapi";
	   }
	
	@RequestMapping(value="/createjob/",method = RequestMethod.GET)
	   public String createJobGet(ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
//		  System.out.println("Create Job call");
//		  System.out.println("Create Job Data :: "+data);
//		  JSONObject json = new JSONObject(data);
//		  Job job = mapper.readValue(data,Job.class);
//		  JobDao jobDao=new JobDao();
//		  jobDao.save(job);
		  model.addAttribute("message", "Hello");
		  return "instaapi";
	   }

}
