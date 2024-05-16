package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bill_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="Hsn_no")
	private Integer HsnNo;
	@Column(name="Mrp")
	private Integer Mrp;
	@Column(name="Product_name")
	private String productName;
	@Column(name="Description")
	private String Description;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Column(name="current_stock")
	private Integer currentStock;
	@Column(name="unit_price")
	private Integer unitPrice;
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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