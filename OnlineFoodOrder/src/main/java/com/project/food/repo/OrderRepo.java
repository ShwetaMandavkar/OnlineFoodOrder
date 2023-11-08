package com.project.food.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.food.entity.Order;
import com.project.food.entity.User;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

	List<Order> findByUser(User user);

}
