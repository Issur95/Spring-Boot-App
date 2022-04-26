package com.app.pack.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.pack.entity.Role;
import com.app.pack.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserDetailsServiceImplementation implements UserDetailsService{

	
	@Autowired
	UserRepository userRepository;
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.app.pack.entity.User UserEnUso = userRepository.findByNombre(username).orElseThrow(() -> new UsernameNotFoundException("User no encontrado"));
		
		Set lista =new HashSet();
		for (Role rol: UserEnUso.getRoles()) {
			GrantedAuthority L = new SimpleGrantedAuthority(rol.getDescription());
			lista.add(L);
			
		}
		UserDetails U = (UserDetails) new User (username, UserEnUso.getPassword(), lista);
		return U;
	}


	
}
