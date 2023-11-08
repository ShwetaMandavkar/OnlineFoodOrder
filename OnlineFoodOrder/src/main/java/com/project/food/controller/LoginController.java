//package com.project.food.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.project.food.entity.Customer;
//import com.project.food.repo.UserRepo;
//
//@Controller
//public class LoginController {
//	@Autowired
//	
//	UserRepo cr;
//
//	@GetMapping("/login")
//	public String getLoginPage(@ModelAttribute("customer") Customer customer) {
//		return "login";
//	}
//	
//	@GetMapping("/logout")
//	public String logout(@ModelAttribute("customer") Customer customer) {
//		return "home";
//	}
//	
//
//	@PostMapping("/login")
//	public String UserLogin(@RequestParam("emailId") String emailId,
//			@RequestParam("password") String password) {
//		Customer c = cr.findByEmailId(emailId);
//		if (c != null && password.equals(c.getPassword())) {
//			
//			return "userdash";
//		}
//
//		return "error";
//
//	}
//	@GetMapping("/logoutuser")
//	public String getLogout(@ModelAttribute("customer") Customer customer) {
//		return "home";
//	}
//	
////	// Mapping for user to go to UpdateDetails page
////		@GetMapping("/updateuser")
////	    public String getUpdatePage(Model model, @RequestParam String emailId) { 
////	        Customer customer = cr.findByemailId(emailId); 
////	        model.addAttribute("user", customer);
////	        return "login";
////	    }
////
////		// Mapping to save updated details
////		@PostMapping("/updateuser")
////		public String updateUser(@ModelAttribute Customer updatedCustomer) {
////			cr.save(updatedCustomer);
////			return "updateuser"; 
////		}
//}