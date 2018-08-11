package com.artiope.springbootmaven.service;

import java.util.List;

import com.artiope.springbootmaven.entity.mongo.User;


public interface UserService {
	 public List<User> findByName(String name);
	 public User findUserByNameAndPwd(String name,String pwd);
	 public List<User> findUserByNameOrPwd(String name,String pwd);
	 void save(User user);
}
