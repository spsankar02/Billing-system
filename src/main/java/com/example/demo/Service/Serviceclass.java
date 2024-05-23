package com.example.demo.Service;


import java.text.ParseException;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Billing;
import com.example.demo.model.Invoice;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetails;
import com.example.demo.model.Product;
import com.example.demo.repository.Invoicerepo;
import com.example.demo.repository.Orderdetailsrepo;
import com.example.demo.repository.Orderrepo;
import com.example.demo.repository.Productrepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

@Service
public class Serviceclass implements ServiceInterface{
	@Autowired
	private Productrepo productrepo;
	@Autowired
	private Orderrepo orderrepo;
	@Autowired
	private Orderdetailsrepo orderdetailsrepo;
	@Autowired
	private Invoicerepo invoicerepo;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public Product create(Product value) {
		System.out.println(value.getInitialStock());
		  List<OrderDetails> orderDetails = orderdetailsrepo.findByProductId(value.getId());
		    if (orderDetails.isEmpty()) {
		        value.setCurrentStock(value.getInitialStock());	        
		    } 
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

	public void createInvoice(Map<String,Object> payload) throws ParseException {
		Order order=new Order();
        Billing user = objectMapper.convertValue(payload.get("user"), Billing.class);
		order.setUser(user);
		order.setOrderAmount((Double)payload.get("overalltotal"));
		String d = (String) payload.get("createdDate");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(d, formatter);
        LocalDate localDate = zonedDateTime.toLocalDate();
        order.setOrderDate(localDate);
		order.setOrderStatus((String)payload.get("status"));
	
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> orderDetailsPayload = (List<Map<String, Object>>) payload.get("orderDetails");
		List<OrderDetails> orderDetails = orderDetailsPayload.stream().map((Map<String, Object> detail) -> {
		    OrderDetails orderDetail = new OrderDetails();
		    orderDetail.setOrder(order);
		    orderDetail.setOrderQuantity(objectMapper.convertValue(detail.get("quantityList"), Integer.class));
		    orderDetail.setOrderPrice(objectMapper.convertValue(detail.get("totalList"), Double.class));
		    orderDetail.setProduct(objectMapper.convertValue(detail.get("productDetailsList"), Product.class));
		    return orderDetail;
		}).collect(Collectors.toList());
		long totalQuantity = orderDetails.stream().mapToLong(detail -> detail.getOrderQuantity()).sum();
		order.setItems(totalQuantity);
	    order.setOrderDetails(orderDetails);		
	    orderrepo.save(order);
		orderdetailsrepo.saveAll(orderDetails);
		Invoice invoice = new Invoice();
		invoice.setOrder(order);
		invoice.setAmount((Double)payload.get("overalltotal"));
		String createddate=(String)payload.get("dueDate");
		DateTimeFormatter formatters = DateTimeFormatter.ISO_DATE_TIME;
	    ZonedDateTime zonedDateTimee = ZonedDateTime.parse(createddate, formatters);
        LocalDate localDatee = zonedDateTimee.toLocalDate();
        invoice.setCreatedDate(localDate);
        invoice.setDueDate(localDatee);
		invoice.setStatus((String)payload.get("status"));
		invoice.setCustomerName(user.getCustomerName());
		invoicerepo.save(invoice);
		System.out.println(payload);
		if(!invoice.getStatus().contains("Draft"))
		 for (OrderDetails detail : orderDetails) {
		        Product product = detail.getProduct();
		        int orderQuantity = detail.getOrderQuantity();
		        int currentStock = product.getCurrentStock();
		        product.setCurrentStock(currentStock - orderQuantity);
		        productrepo.save(product);
		    }

	}
	@Override
	public List<Invoice> findAllInvoice() {
		return invoicerepo.findAll();
	}
	
}
