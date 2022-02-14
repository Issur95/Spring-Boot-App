package com.app.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pack.entity.User;
import com.app.pack.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
}
