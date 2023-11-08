package com.project.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.food.entity.Category;
//import com.project.food.entity.Product;
import com.project.food.repo.CategoryRepo;
//import com.project.food.repo.ProductRepo;




@Controller
	public class CategoryController {
	@Autowired
	CategoryRepo categoryRepo;
//	@Autowired
//	ProductRepo productRepo;
	@GetMapping("/admin/category")
    public String showCategoryForm(Model model) {
        // Create an empty Category object
        model.addAttribute("category", new Category());
        return "category";
    }

    @PostMapping("/admin/category")
    public String addCategory(@ModelAttribute("category") Category category, Model model) {
        // Handle saving the category data to a database or performing other actions
        categoryRepo.save(category);
        return "admindash";
    }
  

//    @RequestMapping(value = "/products/search", method = RequestMethod.GET)
//    public String searchProducts(@RequestParam(name = "CategoryId", required = false) Integer categoryId, Model model) {
//        if (categoryId != null) {
//            // Implement code to filter products by categoryId
//            List<Product> filteredProducts = productRepo.findByCategoryId(categoryId);
//
//            // Add the filtered products to the model
//            model.addAttribute("product", filteredProducts);
//        } else {
//            // Handle the case where no category is selected (e.g., show all products)
//            List<Product> allProducts = productRepo.findAll();
//            model.addAttribute("product", allProducts);
//        }
//
//        return "userdash"; // Replace with the appropriate view name
//    }
    
}
	


