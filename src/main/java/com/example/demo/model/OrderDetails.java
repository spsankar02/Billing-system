package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="order_quantity")
	private Integer orderQuantity;
	@Column(name="order_price")
    private Double orderPrice;
	@ManyToOne
	@JoinColumn(name = "orders_id")
	@JsonBackReference
	private Order order;
	@ManyToOne
	@JoinColumn(name = "bill_product_id")
	private Product product;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
