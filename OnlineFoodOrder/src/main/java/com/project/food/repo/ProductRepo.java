package com.project.food.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.food.entity.Category;
import com.project.food.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	//Product save(Product product);
	 List<Product> findByCategoryId(int categoryId);

	Optional<Product> findById(Integer productId);
	@Modifying
	@Transactional
	@Query("DELETE FROM Product p WHERE p.id = :productId")
	void deleteById(@Param("productId") Integer productId);
}
			
		


