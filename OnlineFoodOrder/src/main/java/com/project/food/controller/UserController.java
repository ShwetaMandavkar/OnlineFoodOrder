package com.project.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.food.entity.User;
import com.project.food.repo.UserRepo;
import com.project.food.service.UserService;
/**
 * Shweta Mandavkar
 */




@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserService userService;
	@Autowired
	public PasswordEncoder passwordEncoder;
	
//	@GetMapping("/")
//	public String login() {
//		return"login";
//	}
	
	/*
	 * Mapping for Homepage
	 */
	@GetMapping("/home")
	public String Home() {
		return "home";
	}
	/*
	 * Mapping for Aboutus page
	 */
	@GetMapping("/aboutus")
	public String Aboutus() {
		return "aboutus";
	}
	
	/*
	 * Mapping for Userlogin page
	 */

	
	@GetMapping("/login")
	public String getLoginPage( User user) {
		return "login";
	}
	/*
	 * Mapping for User dashboard 
	 */
	@GetMapping("/userdash")
	public String userHome() {
		return "userdash";
	}
	/*
	 * Mapping for logout 
	 */

	@GetMapping("/logoutuser")
	public String getLogoutPage( User user) {
		return "home";
	}
	

	/*
	 * Mapping for Update user details
	 */
	

@GetMapping("/updateuser")
public String userUpdate(Model model) {
    // Get the currently logged-in user's email
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    
    // Find the user by email
    User user = userRepo.findByEmail(username);
    
    if (user == null) {
        // Handle the case where the user is not found, e.g., show an error message
        return "error"; // Create an error page or specify a different error handling mechanism
    }
    
    model.addAttribute("user", user);
    return "updateuser";
}

//@PostMapping("/saveUpdates")
//public String updateDetails(@ModelAttribute User user) {
//    userService.updateUserDetails(user);
//    return "redirect:/user/userHome"; // Redirect to the home page after updating details
//}

/*
 * Mapping for save updated details 
 */

@PostMapping("/saveUpdates")
public String saveUpdates(@ModelAttribute User user, @RequestParam("newPassword") String newPassword) {
    // Retrieve the user from the database by their ID.
    User existingUser = userRepo.findById(user.getId()).orElse(null);
    
    if (existingUser != null) {
        // Update the user's details based on the form data.
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        existingUser.setContact(user.getContact());

        if (!newPassword.isEmpty()) {
            // Hash the new password and update the user's password.
            String hashedPassword = passwordEncoder.encode(newPassword);
            existingUser.setPassword(hashedPassword);
        }

        // Save the updated user in the database.
        userRepo.save(existingUser);
    }

    return "home";
}


	}

