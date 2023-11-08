package com.project.food.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.project.food.entity.Cart;
import com.project.food.entity.Category;

import com.project.food.entity.Product;
import com.project.food.entity.User;
import com.project.food.repo.CartRepo;

import com.project.food.repo.ProductRepo;
import com.project.food.repo.UserRepo;
import com.project.food.service.CartService;
import com.project.food.service.ProductService;

@Controller
@RequestMapping("/user")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ProductService productService;



	@GetMapping("/cart")
	public String showShoppingCart(Model model, Principal principal) {
		String username = principal.getName(); // Get the username of the currently logged-in user
		User currentUser = userRepo.findByEmail(username);

		List<Cart> cartItems = cartService.listCartItems(currentUser);

		// Calculate the total amount
		double totalAmount = 0;
		for (Cart cartItem : cartItems) {
			totalAmount += cartItem.getProduct().getPrice() * cartItem.getQuantity();
		}

		model.addAttribute("cartItems", cartItems);
	
		model.addAttribute("totalAmount", totalAmount);
		System.out.println("totalamount="+totalAmount);
		return "cart";
	}

	@PostMapping("/cart/{productId}")
	public String addToCart(@PathVariable int productId, Principal principal,Model model) {
		// Get the currently logged-in user
		String username = principal.getName();
		
		

		// Retrieve the book with the given id (you'll need to implement this method)
		Product selectedProduct = productService.getProductsById(productId);

		// Add the book to the user's cart (you'll need to implement this method)
		cartService.addToCart(username, selectedProduct);

		model.addAttribute("addToCartSuccessMessage", selectedProduct.getName() + " has been added to your cart.");
		
		return "redirect:/user/products";
	}

//	@PostMapping("/user/deleteproduct/{productId}")
//	public String deleteProduct(@RequestParam("productId") Integer productId) {
//		cartService.deleteById(productId);
//		return "redirect:/user/cart"; // Redirect to the product list page or another appropriate page
//	}
//	@GetMapping("/deleteproduct/{cartId}")
//    public String deleteCartItem(@PathVariable Integer cartId, Model model) {
//        // Call your CartService to remove the item with the given id from the cart.
//        cartService.removeItemFromCart(cartId);
//
//        // You can add more logic here, such as updating the cart or recalculating the total.
//
//        // Redirect to the cart page or another appropriate page.
//        return "redirect:/user/cart";
//    }




	@PostMapping("/user/deleteproduct/{cartId}")
	public String deleteCartItem(@RequestParam("cartId") Integer cartId) {
		//Cart cart=new Cart();
		//this.id=cart.getId();
	    cartService.deleteByCartId(cartId); // Make sure this method is correctly implemented
	    return "redirect:/user/cart"; // Redirect to the cart page
	    
	}
	
//	 @DeleteMapping("/removeItem/{cartId}/{productId}")
//	    public ResponseEntity<String> removeItem(@PathVariable Integer cartId, @PathVariable Integer productId) {
//	        cartService.deleteById(cartId, productId);
//	        return ResponseEntity.ok("Item removed from the cart");
//	    }

	
	 
}

	

	 
	
	
