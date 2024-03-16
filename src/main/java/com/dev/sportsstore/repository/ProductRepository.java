package com.dev.sportsstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.sportsstore.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Iterable<Product> findAllByCategory(String category);
	

}
