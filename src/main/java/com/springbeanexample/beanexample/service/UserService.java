package com.springbeanexample.beanexample.service;

import java.util.List;

import com.springbeanexample.beanexample.entity.User;

public interface UserService {

	User getUser (Long id);
	String addUser(User user);
	String updateUser(User user); 
	String removeUser(Long id); 
	List<User> allUsers(); 
}
