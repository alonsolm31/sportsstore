package com.dev.sportsstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.sportsstore.model.Order;
import com.dev.sportsstore.model.Product;
import com.dev.sportsstore.service.OrderService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public Iterable<Order> getAllOrders() {
		return orderService.getOrder();
	}
	
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable("id") long orderId, @RequestBody Order order){
		return orderService.updateOrder(orderId, order);
	}
	
	@DeleteMapping("/{id}")
	void deleteOrderById(@PathVariable("id") long orderId) {
		orderService.deleteOrderById(orderId);
	}
	

}
