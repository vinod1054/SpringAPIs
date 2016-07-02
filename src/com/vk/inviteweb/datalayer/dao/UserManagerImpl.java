package com.vk.inviteweb.datalayer.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.inviteweb.datalayer.model.User;

//@Service
public class UserManagerImpl implements UserManager{
	
	//@Autowired
	UserDao userDao;

	//@Transactional
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
