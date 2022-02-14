package com.app.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pack.entity.Product;
import com.app.pack.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Iterable<Product> getAllProducts(){
		return productRepository.findAll();
	}
}
