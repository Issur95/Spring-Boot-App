package com.app.pack.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.pack.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{

	public Set<Product> findByNombreP( String nombrep );
	public Set<Product> findByCodBarras( int codBarras );
	public Set<Product> findByCodQR ( int QR );

}
