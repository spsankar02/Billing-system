package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "invoice")

public class Invoice implements Serializable{
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="status")
	private String status;
	@Column(name="created_date")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate createdDate;
	@Column(name="due_date")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private LocalDate dueDate;
	@Column(name="amount")
    private Double amount;
	@ManyToOne
	@JoinColumn(name = "orders_id")
	@JsonManagedReference
	private Order order;

	@Column(name="sub_total")
	private Double subTotal;
	@Column(name="discount")
	private Double discount;
	@Column(name="shipment_total")
	private Double shipmentTotal;
	@Column(name="tax_value")
	private Double taxValue;
	
	public Double getTaxValue() {
		return taxValue;
	}
	public void setTaxValue(Double taxValue) {
		this.taxValue = taxValue;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getShipmentTotal() {
		return shipmentTotal;
	}
	public void setShipmentTotal(Double shipmentTotal) {
		this.shipmentTotal = shipmentTotal;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
