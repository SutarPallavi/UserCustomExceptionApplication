package com.springbeanexample.beanexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbeanexample.beanexample.entity.User;
import com.springbeanexample.beanexample.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

	
	@Autowired
	private UserService service; 
	
	@GetMapping("getUser/{id}")
	public User getUser(@PathVariable Long id) {
		
		return service.getUser(id);		
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return service.addUser(user);		
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		return service.updateUser(user);		
	}
	
	@DeleteMapping("/deleteUser")
	public String removeUser(@RequestParam Long id) {
		return service.removeUser(id); 
	}
	
	@GetMapping("/listOfusers")
	public List<User> getAllUsers(){
		return service.allUsers();
	}
}
