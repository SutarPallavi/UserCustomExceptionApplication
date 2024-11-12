package com.springbeanexample.beanexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserCustomExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCustomExceptionApplication.class, args); 
	}
}
