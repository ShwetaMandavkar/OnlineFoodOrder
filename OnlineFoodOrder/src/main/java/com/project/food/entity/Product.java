package com.project.food.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private double price;

   
    @JoinColumn(name = "category_id")// Specify the column to join
  private Integer categoryId;
    @Column(name = "product_image")
    private String productImage;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String name, double price, Integer categoryId, String productImage) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.productImage = productImage;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", categoryId=" + categoryId
				+ ", productImage=" + productImage + "]";
	}

	public Integer getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	}    