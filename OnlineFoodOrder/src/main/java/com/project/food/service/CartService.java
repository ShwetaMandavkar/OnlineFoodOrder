package com.project.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.entity.Cart;
import com.project.food.entity.Product;
import com.project.food.entity.User;
import com.project.food.repo.CartRepo;
import com.project.food.repo.UserRepo;

@Service
public class CartService {

	
//	 public void savecart(Cart cart) {
//		 cartRepo.save(cart);
//	 }
//	public List<Cart> getCart() {
//		// TODO Auto-generated method stub
//		return cartRepo.findAll();
//	}

	
	  
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private UserRepo userRepo;

	public List<Cart> listCartItems(User user) {
		return cartRepo.findByUser(user);
	}

	public void addToCart(String username, Product selectedProduct) {
        // Fetch the user
        User user = userRepo.findByEmail(username);

        // Create a CartItem
        Cart cartItem = new Cart();
        cartItem.setProduct(selectedProduct);
       cartItem.setUser(user);
       cartItem.setQuantity(1); // Set the quantity as needed

        // Add the item to the shopping cart
       cartRepo.save(cartItem);
    }

//	public void deleteById(Integer productId) {
//		// TODO Auto-generated method stub
//		cartRepo.deleteById(productId);
//		
//	}

	public Cart getcartById(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void deleteByCartId(int id) {
		// TODO Auto-generated method stub
		cartRepo.deleteById(id);
		
	}

//	public void deleteById(Integer cartId, Integer productId) {
//		cartRepo.deleteById(cartId);
//		
//		// TODO Auto-generated method stub
//		
//	}
	
	




//	public double calculateTotalAmount(List<Product> products) {
//	    double totalAmount = 0.0; // Initialize the total amount to 0.0
//
//	    for (Product product : products) {
//	        totalAmount += product.getPrice(); // Assuming the Product class has a getPrice() method.
//	    }
//
//	    return totalAmount;
//	}
}
	
