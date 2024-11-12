package com.springbeanexample.beanexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbeanexample.beanexample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findUserById(@Param(value = "id") long id); 
}
