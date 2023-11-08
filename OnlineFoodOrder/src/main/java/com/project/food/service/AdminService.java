//package com.project.food.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.food.entity.Admin;
//import com.project.food.repo.AdminRepo;
//
//@Service
//public class AdminService {
//	@Autowired
//	AdminRepo ar;
//
//	public Boolean authenticateAdmin(Admin ac) {
//		Admin admin = ar.findByUsername(ac.getUserName());
//		if (admin == null) {
//			return false;
//		}
//		if (admin.getPassword() == ac.getPassword()) {
//			return true;
//		}
//		return false;
//	}
//
//}