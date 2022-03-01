package com.app.pack.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pack.entity.Product;
import com.app.pack.entity.User;
import com.app.pack.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Iterable<Product> getAllProducts(){
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) throws Exception {
		if (NombreProductoExistente(product) && CodigoBarrasEnUso(product)) {
		product = productRepository.save(product);
		}
		return product;
	}
	
	private boolean NombreProductoExistente(Product product) throws Exception {
		Set<Product> productFound = productRepository.findByNombreP(product.getNombreP());
		if (!productFound.isEmpty()) {
			throw new Exception("Producto ya existe");
		}
		return true;
	}
	
	private boolean CodigoBarrasEnUso(Product product) throws Exception {
		Set<Product> productFound = productRepository.findByCodBarras(product.getCodBarras());
		if (!productFound.isEmpty()) {
			throw new Exception("Codigo de barras en uso");
		}
		return true;
	}
}
