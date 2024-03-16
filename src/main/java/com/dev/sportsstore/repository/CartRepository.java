package com.dev.sportsstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.sportsstore.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}
