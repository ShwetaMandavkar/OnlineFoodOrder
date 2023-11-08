package com.project.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.entity.Category;
import com.project.food.repo.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {
	 @Autowired
	    private CategoryRepo categoryRepo;

	
	public List<Category> listAllCategories() {
		return categoryRepo.findAll();
	}
	
}

//	public Object getAllCategories() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	 public List<Category> listAllCategories() {
//       return categoryRepo.findAll();
//
//}

//public interface CategoryService {
//    List<Category> listAllCategories();
//    // Other category-related methods
//}
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public List<Category> listAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    // Implement other methods for category operations
//}
//
//
