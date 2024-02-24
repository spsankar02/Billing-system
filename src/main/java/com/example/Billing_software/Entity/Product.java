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
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;
	@Column(name="Hsn_no")
	private Integer HsnNo;
	@Column(name="Mrp")
	private Integer Mrp;
	@Column(name="Product_name")
	private String productName;
	@Column(name="current_stock")
	private Integer currentStock;
	@Column(name="retail_rate")
	private Integer retailRate;
	@Column(name="wholesale_rate")
	private Integer wholesaleRate;
	@Column(name="min_qty")
	private Integer minQty;
	@Column(name="max_qty")
	private Integer maxQty;
	@Column(name="Gst")
	private Integer Gst;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getHsnNo() {
		return HsnNo;
	}
	public void setHsnNo(Integer hsnNo) {
		HsnNo = hsnNo;
	}
	public Integer getMrp() {
		return Mrp;
	}
	public void setMrp(Integer mrp) {
		Mrp = mrp;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}
	public Integer getRetailRate() {
		return retailRate;
	}
	public void setRetailRate(Integer retailRate) {
		this.retailRate = retailRate;
	}
	public Integer getWholesaleRate() {
		return wholesaleRate;
	}
	public void setWholesaleRate(Integer wholesaleRate) {
		this.wholesaleRate = wholesaleRate;
	}
	public Integer getMinQty() {
		return minQty;
	}
	public void setMinQty(Integer minQty) {
		this.minQty = minQty;
	}
	public Integer getMaxQty() {
		return maxQty;
	}
	public void setMaxQty(Integer maxQty) {
		this.maxQty = maxQty;
	}
	public Integer getGst() {
		return Gst;
	}
	public void setGst(Integer gst) {
		Gst = gst;
	}

}
