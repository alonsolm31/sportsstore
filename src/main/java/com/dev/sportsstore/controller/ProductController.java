package com.dev.sportsstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dev.sportsstore.model.Product;
import com.dev.sportsstore.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private   ProductService productService;
	
	@GetMapping
	public Iterable<Product> getAllProducts(){
		return productService.getProduct();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable("id") long productId){
		return productService.getProductById(productId);
	} 
	
	@GetMapping("/category/{name}")
	public Iterable<Product> getProductByCategory(@PathVariable("name") String category){
		return productService.getProductsByCategory(category);
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public void updateProduct(@PathVariable("id") long productId, @RequestBody Product product) {
		productService.updateProduct(productId, product);
	}
	
	@DeleteMapping("/{id}")
	void deleteProductById(@PathVariable("id") long productId) {
		productService.deleteProductById(productId);
	}
	
	@DeleteMapping
	void deleteProducts() {
		productService.deleteProducts();
	}
	
	

}
