package com.dev.sportsstore.service;

import java.util.Optional;

import com.dev.sportsstore.model.Product;

public interface ProductService {
	
	Product createProduct(Product product);
	
	Optional<Product> getProductById(long productId);
	
	Iterable<Product> getProductsByCategory(String category);
	
	Iterable<Product> getProduct();
	
	Product updateProduct(long productId, Product product);
	
	void deleteProductById(long productId);
	
	void deleteProducts();
}
