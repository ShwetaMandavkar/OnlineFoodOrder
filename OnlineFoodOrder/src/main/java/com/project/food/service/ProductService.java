package com.project.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.food.entity.Product;
import com.project.food.repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
//    @Autowired
//    private CartService cartService;
//    
    
    public void saveupdatedProduct(Product product) {
        productRepo.save(product);
     }
//    public void deleteProductByName(String productName) {
//        productRepo.deleteByName(productName);
//    }
//   

    // You can add other methods for product-related operations
    
    public Product saveProduct(Product product) {
        // Save the product to the database
        Product savedProduct = productRepo.save(product);

        // You can now use the saved product's ID to generate a unique image file name
        String imageFileName = "product_" + savedProduct.getProductId() + ".jpg";
        savedProduct.setProductImage(imageFileName);

        // Save the image file to the file system (e.g., in the 'images' folder)
        // Implement this part based on your file upload configuration

        return savedProduct;
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
		return productRepo.findByCategoryId(categoryId);
	}
    public Product getProductsById(int Id) {
		return productRepo.findById(Id).get();
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
	
	public void deleteById(int id) {
		productRepo.deleteById(id);
	}

	
	
//	 public void deleteProduct(Integer productId) {
//		// Delete associated cart items
//		    cartService.deleteCartItemsByProductId(productId);
//
//	        productRepo.deleteById(productId); // Delete the product by ID
//	    }
	 
	
}
