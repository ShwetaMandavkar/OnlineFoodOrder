package com.project.food.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date")
	private Date orderDate;
	

	@Column(name = "total_amount")
	private double totalAmount;
	
//	@ManyToOne
//	@JoinColumn(name = "cart_id")
//	private Cart cart;

	@Column(name = "status")
	private String status;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, User user, Date orderDate, double totalAmount, String status) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		//this.cart = cart;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
//
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	



	

	public Order(Date orderDate, String status) {
		super();
		this.orderDate = new Date();
		this.status = "Not Delivered";
	}
}

	
	