package com.springbeanexample.beanexample.exceptions;

import org.springframework.http.HttpStatus;

public class NoSuchUserExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchUserExistException() {
		super();
	}
	
	public NoSuchUserExistException(String message) {
		super(message);	
	}
	
	public NoSuchUserExistException(String errorMessage, Throwable exception) {
		super(errorMessage, exception);
	}
}
