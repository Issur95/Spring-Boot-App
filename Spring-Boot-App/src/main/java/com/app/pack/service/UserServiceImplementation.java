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
			user= userRepository.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		User user= userRepository.findById(id).orElseThrow(()-> new Exception("No existe el usuario"));
		return user;
	}

	@Override
	public User updateUser(User oldUser) throws Exception {
		User newUser = getUserById(oldUser.getUid());
		mapUser(oldUser, newUser);
		userRepository.save(newUser);
		return newUser;
		
	}

	protected void mapUser(User oldUser, User newUser) {
		newUser.setNombre(oldUser.getNombre());
		newUser.setApellido1(oldUser.getApellido1());
		newUser.setApellido2(oldUser.getApellido2());
		newUser.setDni(oldUser.getDni());
		newUser.setFechaNac(oldUser.getFechaNac());
		newUser.setDni(oldUser.getDni());
		newUser.setPassword(oldUser.getPassword());
	}
}
