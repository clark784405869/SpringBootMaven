package com.artiope.springbootmaven.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.artiope.springbootmaven.entity.mongo.User;
import org.springframework.stereotype.Service;

import com.artiope.springbootmaven.dao.mongo.UserRepository;
import com.artiope.springbootmaven.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	 @Resource
	    private UserRepository userRepository;

	@Override
	public List<User> findByName(String name) {
		
		return userRepository.findByName(name);
		
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserByNameAndPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		return userRepository.findUserByNameAndPwd(name, pwd);
	}

	@Override
	public List<User> findUserByNameOrPwd(String name, String pwd) {
		// TODO Auto-generated method stub
		return userRepository.findUserByNameOrPwd(name, pwd);
	}
	 
	   
	
	

}
