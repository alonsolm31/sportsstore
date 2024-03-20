package com.dev.sportsstore.service;

import com.dev.sportsstore.model.Order;
import com.dev.sportsstore.model.Product;

public interface OrderService {
	
	Order createOrder(Order order);
	
	Iterable<Order> getOrder();
	
	void deleteOrderById(long orderId);
	
	Order updateOrder(long orderId, Order order);

}
