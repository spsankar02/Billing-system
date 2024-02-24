package com.example.Billing_software.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="beat_name")
	private String beatName;
	@Column(name="Address")
	private String Address;
	@Column(name="phone_no")
	private Long phoneNo;
	@Column(name="Gst_no")
	private Integer GstNo;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBeatName() {
		return beatName;
	}
	public void setBeatName(String beatName) {
		this.beatName = beatName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Integer getGstNo() {
		return GstNo;
	}
	public void setGstNo(Integer gstNo) {
		GstNo = gstNo;
	} 
	
	
}
