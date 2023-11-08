package com.project.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.food.entity.User;
import com.project.food.repo.UserRepo;

import jakarta.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    public BCryptPasswordEncoder passwordEncoder;
    
    public User saveUser(User user) {
    	String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		User newuser = userRepo.save(user);
		return newuser;
    }
    
    public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}
 // Retrieve user details by ID
    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

    // Update user details
    public void updateUserDetails(User updatedUser) {
        // Retrieve the existing user details
        User existingUser = getUserById(updatedUser.getId());

        if (existingUser != null) {
            // Update the existing user's details with the new values
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setContact(updatedUser.getContact());
            // You can update other fields as needed

            // Save the updated user back to the database
            userRepo.save(existingUser);
        }
    }
	

}

