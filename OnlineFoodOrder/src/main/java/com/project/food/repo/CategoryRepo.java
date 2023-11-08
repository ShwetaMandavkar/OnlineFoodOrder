package com.project.food.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.food.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	//Optional<Category> findById(Category category);

}

