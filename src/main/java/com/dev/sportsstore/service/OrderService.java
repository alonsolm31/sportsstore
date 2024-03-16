package com.dev.sportsstore.service;

import com.dev.sportsstore.model.Order;

public interface OrderService {
	
	Order createOrder(Order order);
	
	Iterable<Order> getOrder();
	
	void deleteOrderById(long orderId);

}
