package com.project.food.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.entity.Cart;
import com.project.food.entity.Order;
import com.project.food.entity.User;
import com.project.food.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	// Method to create an order
	public Order createOrder(User user, double totalAmount) {
		// Create a new Order
		Order order = new Order();
		order.setUser(user);
		order.setOrderDate(new Date()); // Set the order date to the current date
		order.setTotalAmount(totalAmount);
		order.setStatus("not delivered"); // Set the initial order status

		return orderRepo.save(order);
	}

	// Method to retrieve orders by user
	public List<Order> getOrdersByUser(User user) {
		return orderRepo.findByUser(user);
	}
	
//	public void calculateTotalAmountForOrders(List<Order> orders) {
//	    for (Order order : orders) {
//	        double totalAmount = 0;
//	        for (Cart cartItem : cartItems) {
//			totalAmount += cartItem.getProduct().getPrice() * cartItem.getQuantity();
//			}
//	        order.setTotalAmount(totalAmount);
//	    }
//	}

	public void addtoOrder(String username, Cart selectedcart) {
		// TODO Auto-generated method stub
		
	}

	
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	 }
}