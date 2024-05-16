package com.example.demo.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.Productrepo;

import jakarta.transaction.Transactional;

@Service
public class Serviceclass implements ServiceInterface{
	@Autowired
	private Productrepo productrepo;
	

	@Override
	public Product create(Product value) {
		return productrepo.save(value);
	}

	@Override
	public List<Product> findAllProduct() {
		return productrepo.findAll();
	}

	@Override
	public Product update(Map<String, Object> payload) {
	    String id = (String) payload.get("id");
	    Long productId = Long.parseLong(id);
	    Product product = productrepo.findById(productId)
	            .orElseThrow(() -> new IllegalArgumentException("Product not found"));

	    System.out.println("Payload: " + payload);

	    try {
			  Object hsnNovalue = payload.get("hsnNo");
			  String hsnNo;

			  if (hsnNovalue instanceof Integer) {
				  hsnNo = String.valueOf(hsnNovalue);
			  } else if (hsnNovalue instanceof String) {
				  hsnNo = (String) hsnNovalue;
			  } else {
			      throw new IllegalArgumentException("Invalid hsnNo value: " + hsnNovalue);
			  }
			  Object mrpvalue = payload.get("mrp");
			  String mrp;

			  if (mrpvalue instanceof Integer) {
				  mrp = String.valueOf(mrpvalue);
			  } else if (mrpvalue instanceof String) {
				  mrp = (String) mrpvalue;
			  } else {
			      throw new IllegalArgumentException("Invalid mrp value: " + mrpvalue);
			  }
			  Object unitpricevalue = payload.get("unitPrice");
			  String unitprice;

			  if (unitpricevalue instanceof Integer) {
				  unitprice = String.valueOf(unitpricevalue);
			  } else if (unitpricevalue instanceof String) {
				  unitprice = (String) unitpricevalue;
			  } else {
			      throw new IllegalArgumentException("Invalid unitprice value: " + unitpricevalue);
			  }
			  Object currentstockvalue = payload.get("currentStock");
			  String currentstock;

			  if (currentstockvalue instanceof Integer) {
				  currentstock = String.valueOf(currentstockvalue);
			  } else if (currentstockvalue instanceof String) {
				  currentstock = (String) currentstockvalue;
			  } else {
			      throw new IllegalArgumentException("Invalid currentstock value: " + currentstockvalue);
			  }
			  Object retailratevalue = payload.get("retailRate");
			  String retailrate;

			  if (retailratevalue instanceof Integer) {
				  retailrate = String.valueOf(retailratevalue);
			  } else if (retailratevalue instanceof String) {
				  retailrate = (String) retailratevalue;
			  } else {
			      throw new IllegalArgumentException("Invalid retailrate value: " + retailratevalue);
			  }
			  Object wholesalevalue = payload.get("wholesaleRate");
			  String wholesale;

			  if (wholesalevalue instanceof Integer) {
				  wholesale = String.valueOf(wholesalevalue);
			  } else if (wholesalevalue instanceof String) {
				  wholesale = (String) wholesalevalue;
			  } else {
			      throw new IllegalArgumentException("Invalid wholesale value: " + wholesalevalue);
			  }
			  Object minqtyvalue = payload.get("minQty");
			  String minqty;

			  if (minqtyvalue instanceof Integer) {
				  minqty = String.valueOf(minqtyvalue);
			  } else if (minqtyvalue instanceof String) {
				  minqty = (String) minqtyvalue;
			  } else {
			      throw new IllegalArgumentException("Invalid minqty value: " + minqtyvalue);
			  }
			  Object maxqtyvalue = payload.get("maxQty");
			  String maxqty;

			  if (maxqtyvalue instanceof Integer) {
				  maxqty = String.valueOf(maxqtyvalue);
			  } else if (maxqtyvalue instanceof String) {
				  maxqty = (String) maxqtyvalue;
			  } else {
			      throw new IllegalArgumentException("Invalid maxqty value: " + maxqtyvalue);
			  }
			  Object gstvalue = payload.get("gst");
			  String gst;

			  if (gstvalue instanceof Integer) {
				  gst = String.valueOf(gstvalue);
			  } else if (gstvalue instanceof String) {
				  gst = (String) gstvalue;
			  } else {
			      throw new IllegalArgumentException("Invalid gst value: " + gstvalue);
			  }
			  
			  	
	        product.setHsnNo(Integer.parseInt(hsnNo));
	        product.setMrp(Integer.parseInt(mrp));
	        product.setProductName((String) payload.get("productName"));
	        product.setDescription((String) payload.get("description"));
	        product.setUnitPrice(Integer.parseInt(unitprice));
	        product.setCurrentStock(Integer.parseInt(currentstock));
	        product.setRetailRate(Integer.parseInt(retailrate));
	        product.setWholesaleRate(Integer.parseInt(wholesale));
	        product.setMinQty(Integer.parseInt(minqty));
	        product.setMaxQty(Integer.parseInt(maxqty));
	        product.setGst(Integer.parseInt(gst));
	    } catch (Exception e) {
	        System.err.println("Error while updating product details: " + e.getMessage());
	        e.printStackTrace();
	        throw e;
	    }

	    return productrepo.save(product);
	}

	
	@Transactional
	public String deleteProductdetails(Long productId) {
		   Optional<Product> product = productrepo.findById(productId);
	        if(product.isPresent()) {
	        	productrepo.deleteById(productId);
	        	return "Product details deleted successfully";
	        }else {
	        	throw new IllegalArgumentException("Product details is not found");
	        }	
	}



	
	
}
