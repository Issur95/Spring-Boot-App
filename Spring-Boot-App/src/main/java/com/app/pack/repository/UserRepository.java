package com.app.pack.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.pack.entity.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{

	public Set<User> findByNombre ( String nombre );
	public Set<User> findByEmail ( String email );
	public Set<User> findByDni ( String dni );

}
