package com.app.pack.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.pack.entity.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{

	public Optional<User> findByNombre ( String nombre );
	public Optional<User> findByEmail ( String email );
	public Optional<User> findByDni ( String dni );

}
