//package com.project.food.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.food.entity.Customer;
//import com.project.food.repo.CustomerRepo;
//
//@Service
//
//public class LoginService {
//	@Autowired
//	CustomerRepo customerRepo;
//
//	public Boolean authenticateUser(Customer c) {
//		Customer customer = customerRepo.findBycust_emailid(c.getCust_emailid());
//		if (customer == null) {
//			return false;
//		}
//		if (customer.getCust_password() == c.getCust_password()) {
//			return true;
//		}
//
//		return false;
//
//	}
//
//}