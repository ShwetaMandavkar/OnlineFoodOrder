package com.project.food.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.food.entity.Cart;
import com.project.food.entity.Product;
import com.project.food.entity.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	public List<Cart> findByUser(User user);
	//void deleteById(@Param("productId") Integer productId);
	//void deleteByProductId(@Param("productId") Integer productId);
	
	 Optional<Cart> findById(Integer cartId);

	    @Modifying
	    @Transactional
	    @Query("DELETE FROM Cart c WHERE c.id = :cartId")
	    void deleteById(@Param("cartId") Integer cartId);
	}


	

