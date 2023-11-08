package com.project.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.food.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email) ;
		

}
