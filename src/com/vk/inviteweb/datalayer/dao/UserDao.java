package com.vk.inviteweb.datalayer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.vk.inviteweb.datalayer.model.User;
import com.vk.inviteweb.datalayer.model.UserEvent;

public interface UserDao {
	
	public User save(User user);
	
}
