package com.twg.spring.mydiary.dao;

import java.util.List;

import com.twg.spring.mydiary.entities.User;


public interface UserDaoInterface {
	
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findbyId(int id);
	public List<User>findAll();
	public User findByUsername(String username);  //checking user is in database or not if there return the user and login

}
