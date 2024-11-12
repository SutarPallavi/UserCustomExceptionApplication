package com.springbeanexample.beanexample.exceptions;

public class UserAlreadyExistException extends RuntimeException{
	
	private String message;

	public UserAlreadyExistException() {}

	public UserAlreadyExistException(String message) {
		super();
		this.message = message;
	} 
}
