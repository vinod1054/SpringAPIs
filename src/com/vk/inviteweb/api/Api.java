package com.vk.inviteweb.api;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fdao.PlaceDao;
import instavans.models.Comments;
import instavans.models.Place;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api")
public class Api {
	PlaceDao placeDao=new PlaceDao();
	ObjectMapper mapper = new ObjectMapper();

	
	@RequestMapping(value="/createplace/",method = RequestMethod.GET)
	   public String createPlace(@RequestParam("data") String data,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  System.out.println(data);
			JSONObject json = new JSONObject(data);
		  Place place = mapper.readValue(data,Place.class);
		  placeDao.save(place);
		  model.addAttribute("message", new JSONObject().put("data",mapper.writeValueAsString(place)));
		  return "api";
	   }
	
	@RequestMapping(value="/getplaces/",method = RequestMethod.GET)
	   public String getPlaces(@RequestParam("lat") Double lat,@RequestParam("lang") Double lang,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  List<Place> list=placeDao.getPlaces(lat,lang);
		  model.addAttribute("message", new JSONObject().put("data",mapper.writeValueAsString(list)));
		  return "api";
	   }
	
	@RequestMapping(value="/addcomment/",method = RequestMethod.GET)
	   public String addComment(@RequestParam("placeid") long placeId,@RequestParam("data") String data,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  JSONObject json = new JSONObject(data);
		  Comments comment = mapper.readValue(data,Comments.class);
		  placeDao.addComment(placeId,comment);
		  model.addAttribute("message", "Done");
		  return "api";
	   }
	@RequestMapping(value="/openorclose/",method = RequestMethod.GET)
	   public String addComment(@RequestParam("placeid") long placeId,@RequestParam("isopen") boolean isOpen,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  System.out.println(isOpen);
			placeDao.isOpen(placeId,isOpen);
		  model.addAttribute("message", "Done");
		  return "api";
	   }
	@RequestMapping(value="/search/",method = RequestMethod.GET)
	   public String addComment(@RequestParam("query") String query,ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {
		  List<Place> list=placeDao.getPlaces(query);
		  System.out.println(list.size());
		  model.addAttribute("message", new JSONObject().put("data",mapper.writeValueAsString(list)));
		  return "api";
	   }
}
