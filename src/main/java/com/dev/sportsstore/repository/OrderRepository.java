package com.dev.sportsstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.sportsstore.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
}
