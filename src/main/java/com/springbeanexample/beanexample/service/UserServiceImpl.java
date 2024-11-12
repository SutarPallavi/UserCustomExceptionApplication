package com.springbeanexample.beanexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springbeanexample.beanexample.entity.User;
import com.springbeanexample.beanexample.exceptions.NoSuchUserExistException;
import com.springbeanexample.beanexample.exceptions.UserAlreadyExistException;
import com.springbeanexample.beanexample.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
//	@Override
//	@Cacheable (value = "users", key ="#id")
//	public User getUser(Long id) {
//		try {
//		Optional<User> user = repository.findById(id);
//		
//		return user.get();
//		} catch (Exception ex) {
//			throw new NoSuchUserExistException("No user found");
//		}
//	}
	
//	@Override
//	@Cacheable (value = "users", key ="#id")
//	public User getUser(Long id) {
//
//		User user = repository.findUserById(id);
//		if(user != null) {
//			return user;
//		}
//		else 
//			throw new NoSuchUserExistException("No user found");
//		
//	}
	
	@Override
	@Cacheable (value = "users", key ="#id")
	public User getUser(Long id) {
		return repository.findById(id).orElseThrow(
		() ->  new NoSuchUserExistException("No such user exist")); 
	}

	@Override
	public String addUser(User user) {
		User existingUser = repository.findById((long) user.getId()).orElse(null); 
		if(existingUser == null) {
			repository.save(user);
			return "User saved successfully saved"; 
		} else 
		 throw new UserAlreadyExistException("Customer already exists!"); 
	}

	@Override
	public String updateUser(User user) {
		User existingUser = repository.findById((long) user.getId()).orElse(null); 
		if (existingUser == null) {
			
			throw new NoSuchUserExistException("No such user exit");
		} else 
			existingUser.setName(user.getName());
			existingUser.setAddress(user.getAddress());
			repository.save(existingUser); 			
		return "Record updated Successfully";
	}
	
	@Override 
	public String removeUser(Long id) {
		User existingUser = repository.findById(id).orElse(null); 
		
		if(existingUser == null) {
			throw new NoSuchUserExistException("No such user exit"); 
		}else 
			repository.delete(existingUser);
		return "User removed"; 
	}

	@Override
	public List<User> allUsers() {
		List<User> userList = repository.findAll(); 
		return userList;
	}
}
