package com.vk.inviteweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vk.inviteweb.datalayer.dao.UserManager;
import com.vk.inviteweb.datalayer.model.User;

//@Controller
public class UserController {

	//@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute(value="employee") User user, BindingResult result){
		userManager.save(user);
		return "redirect:/";
	}
	
}
