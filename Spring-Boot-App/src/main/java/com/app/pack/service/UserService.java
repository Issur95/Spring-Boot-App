package com.app.pack.service;

import javax.validation.Valid;

import com.app.pack.entity.User;

public interface UserService {
	public Iterable<User> getAllUsers();

	public User createUser(User formUser) throws Exception;
	
	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;

	

}
