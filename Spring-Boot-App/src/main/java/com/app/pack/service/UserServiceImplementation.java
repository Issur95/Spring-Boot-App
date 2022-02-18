package com.app.pack.service;

import java.util.Optional;
import java.util.Set;

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
	
	private boolean emailNoenUso(User user) throws Exception {
		Set<User> userFound = userRepository.findByEmail(user.getEmail());
		if (!userFound.isEmpty()) {
			throw new Exception("Email en uso");
		}
		return true;
	}


	@Override
	public User createUser(User user) throws Exception {
		if (emailNoenUso(user)) {
			user = userRepository.save(user);
		}
		return user;
	}
}
