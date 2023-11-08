package com.project.food.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.food.entity.Cart;
import com.project.food.entity.Order;
import com.project.food.entity.Product;
import com.project.food.entity.User;
import com.project.food.repo.CartRepo;
import com.project.food.repo.UserRepo;
import com.project.food.service.CartService;
import com.project.food.service.OrderService;
import com.project.food.service.ProductService;
import com.project.food.service.UserService;

@Controller
@RequestMapping("/user")
public class OrderController {

	@Autowired
	private CartService cartService;
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private ProductService productService;


	@Autowired
	private OrderService orderService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	// Create an order
	@GetMapping("/placeOrder")
	public String placeOrder(Principal principal, Model model, @RequestParam("totalAmount") double totalAmount) {
		System.out.println("total="+totalAmount);
		String username = principal.getName();
		User user = userRepo.findByEmail(username);

		Order order = orderService.createOrder(user, totalAmount);
	//	cartRepo.delete(cartItem);
		

		// You can add additional logic here if needed

		return "redirect:/user/orders ";
	}

	// Retrieve orders for a user
	@GetMapping("/orders")
	public String viewOrders(Principal principal, Model model) {
		String username = principal.getName();
		User user = userRepo.findByEmail(username);
		 // Retrieve the total amount from your "mycart" table. Replace this with your actual logic.
		//List<Product> products = productService.getAllProducts(); // Replace with your actual method to fetch products.

		//double totalAmount = cartService.calculateTotalAmount(products);


	    // Add the total amount to the model so that it can be accessed in Thymeleaf.
	    //model.addAttribute("totalAmount", totalAmount);


		List<Order> orders = orderService.getOrdersByUser(user);

		model.addAttribute("orders", orders);

		return "orders";
	}
	@GetMapping("/allorders")
	public String viewAllOrders(Model model) {
		List<Order> allOrders = orderService.getAllOrders();
		model.addAttribute("orders", allOrders);
		return "allorders"; 
	}
	

}
