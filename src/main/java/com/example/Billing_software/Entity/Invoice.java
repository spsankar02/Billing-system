package com.example.Billing_software.Entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name="invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="invoice_id")
	private Long invoiceId;
	@Column(name="invoice_date")
	private LocalDateTime invoiceDate;
	@Column(name="invoice_amount")
	private Integer invoiceAmount;
	@OneToOne
	@JoinColumn(name="order_id")
	private Orders orders;
	public Long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public LocalDateTime getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDateTime invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Integer getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(Integer invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
}
