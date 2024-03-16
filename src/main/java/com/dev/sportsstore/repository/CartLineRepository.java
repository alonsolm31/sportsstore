package com.dev.sportsstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.sportsstore.model.CartLine;

@Repository
public interface CartLineRepository extends CrudRepository<CartLine, Long>{

}
