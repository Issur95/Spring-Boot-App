package com.app.pack.service;

import com.app.pack.entity.Product;


public interface ProductService {
	public Iterable<Product> getAllProducts();

	public Product createProduct(Product formProduct) throws Exception;

	public Product getProductById(Long id) throws Exception;
	
	public Product updateProduct(Product product) throws Exception;

	public void deleteProduct(Long id) throws Exception;
}
