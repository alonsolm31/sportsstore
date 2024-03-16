package com.dev.sportsstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.sportsstore.exception.ProductNotFoundException;
import com.dev.sportsstore.model.Product;
import com.dev.sportsstore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getProductById(long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Override
	public Iterable<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.findAllByCategory(category);
	}

	@Override
	public Iterable<Product> getProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(long productId, Product product) {
		// TODO Auto-generated method stub
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException(String.format("No product with id %s is available", productId)));
		
		existingProduct.setName(product.getName());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		
		return productRepository.save(existingProduct);
		
	}

	@Override
	public void deleteProductById(long productId) {
		// TODO Auto-generated method stub
		productRepository.findById(productId)
			.orElseThrow(() -> new ProductNotFoundException(String.format("No product with id %s is available", productId)));
		
		productRepository.deleteById(productId);
		
	}

	@Override
	public void deleteProducts() {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
	}

}
