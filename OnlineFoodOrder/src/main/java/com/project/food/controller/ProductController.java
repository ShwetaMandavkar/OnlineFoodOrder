package com.project.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.food.entity.Category;
import com.project.food.entity.Product;
import com.project.food.repo.ProductRepo;
import com.project.food.service.CategoryService;
import com.project.food.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping("/admin/product")
	public String showProductForm(Model model) {
		// Create an empty Category object
		model.addAttribute("product", new Product());
		return "product";
	}

	@PostMapping("/admin/product")
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		// Handle saving the category data to a database or performing other actions
		productRepo.save(product);
		return "success";
	}

	@GetMapping("/admin/addproduct")

	public String add(Model model) {
		List<Category> listcategory = categoryService.listAllCategories();
		// Create an empty Category object
		model.addAttribute("listcategory", listcategory);
		model.addAttribute("product", new Product());
		return "addproduct";
	}

	@PostMapping("/admin/addproduct")
	public String processAddProduct(@ModelAttribute("product") Product product, BindingResult bindingResult,
			@RequestParam("CategoryId") int CategoryId, Model model) {
if (bindingResult.hasErrors()) {
			// If there are validation errors, return to the form with error messages
			List<Category> listcategory = categoryService.listAllCategories();
			model.addAttribute("listcategory", listcategory);
			return "addproduct";
		}

		product.setCategoryId(CategoryId);

		// If validation passes, save the product to the database
		productService.saveProduct(product);

		// Redirect to a success page or the product list page
		return "admindash";
	}
	

	@GetMapping("/user/products")
    public String listProducts(Model model) {
		List<Category> listcategory = categoryService.listAllCategories();
        List<Product> products = productRepo.findAll();
        model.addAttribute("listcategory", listcategory);
        model.addAttribute("product", new Product());
        model.addAttribute("products", products);
        return "userproduct";
    }

	
	
	 @GetMapping("/admin/productlist")
	    public String productList(Model model) {
	        List<Product> products = productService.getAllProducts(); // Fetch all products from the database
	        model.addAttribute("products", products);
	        return "productlist"; // Return the name of your Thymeleaf template
	    }
	 

	    @PostMapping("/admin/deleteproduct/{productId}")
	    public String deleteProduct(@RequestParam("productId") Integer productId) {
	        productService.deleteById(productId);
	        return "redirect:/admin/productlist"; // Redirect to the product list page or another appropriate page
	    }

	    
	}
	
	 
	 
	 
	 
	 
	 
	 
	 
	
	

