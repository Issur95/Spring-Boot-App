package com.app.pack.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		Optional<User> userFound = userRepository.findByEmail(user.getEmail());
		if (!userFound.isEmpty()) {
			throw new Exception("Email en uso");
		}
		return true;
	}


	@Override
	public User createUser(User user) throws Exception {
		if (emailNoenUso(user)) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public User updateUser(User User) throws Exception {
		User newUser = getUserById(User.getUid());
		mapUser(User, newUser);
		userRepository.save(newUser);
		return newUser;
		
	}

	protected void mapUser(User User, User newUser) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		newUser.setNombre(User.getNombre());
		newUser.setApellido1(User.getApellido1());
		newUser.setApellido2(User.getApellido2());
		newUser.setDni(User.getDni());
		newUser.setFechaNac(User.getFechaNac());
		newUser.setDni(User.getDni());
		newUser.setPassword(bCryptPasswordEncoder.encode(User.getPassword()));
		newUser.setRoles(User.getRoles());
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
		userRepository.delete(user);
	}
}
