package com.app.pack.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	public UserDetails loadUserByUsername (String nombre) throws UsernameNotFoundException {
		
		
		com.app.pack.entity.User UserEnUso = userRepository.findByNombre(nombre).orElseThrow(() -> new UsernameNotFoundException("Nombre no valido."));
		
		Set<GrantedAuthority> lista = new HashSet<GrantedAuthority>();
		for (Role rol: UserEnUso.getRoles()) {
			GrantedAuthority L = new SimpleGrantedAuthority(rol.getDescription());
			lista.add(L);
				
		}
		UserDetails U = (UserDetails) new User (UserEnUso.getNombre(), UserEnUso.getPassword(), lista);
		return U;
			
			/*
		}
		catch (Exception e) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}	
		
		Set<GrantedAuthority> roles = new HashSet<>();
		GrantedAuthority L = new SimpleGrantedAuthority("ROLE_ADMIN");
		roles.add(L);
		
		UserDetails U = (UserDetails) new User ("admin", "$2a$04$k/J2em.o1VDphk950ei99uFQnMJmi07bdF.C4rMd02fNXUoVAcylq", roles);
		return U;
		*/
	}


	
}
