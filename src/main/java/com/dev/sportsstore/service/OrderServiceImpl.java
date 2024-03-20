package com.dev.sportsstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.sportsstore.exception.OrderNotFoundException;
import com.dev.sportsstore.exception.ProductNotFoundException;
import com.dev.sportsstore.model.Cart;
import com.dev.sportsstore.model.CartLine;
import com.dev.sportsstore.model.Order;
import com.dev.sportsstore.model.Product;
import com.dev.sportsstore.repository.CartLineRepository;
import com.dev.sportsstore.repository.CartRepository;
import com.dev.sportsstore.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartLineRepository cartLineReporitory;
	
	@Override
	public Order createOrder(Order order) {
		
		Cart cart = new Cart();
		cart.setCartPrice(order.getCart().getCartPrice());
		cart.setItemCount(order.getCart().getItemCount());
		cart = cartRepository.save(cart);
		long cartId = cart.getCartId();
		
			
		order.getCart().getCartLine().forEach(cl ->{ 
			CartLine cartLine = new CartLine();	
			cartLine.setCartId(cartId);
			cartLine.setQuantity(cl.getQuantity());
			cartLine.setProduct(cl.getProduct());
			
			cartLineReporitory.save(cartLine);
			
		} );
		
		
		order.setCart(cart);
		
		return orderRepository.save(order);
	}

	@Override
	public Iterable<Order> getOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrderById(long orderId) {
		orderRepository.deleteById(orderId);
	}

	@Override
	public Order updateOrder(long orderId, Order order) {
		// TODO Auto-generated method stub
		Order existingOrder = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException(String.format("No order with id %s is available", orderId)));
		
		existingOrder.setShipped(order.isShipped());
		return orderRepository.save(existingOrder);
	}

}
