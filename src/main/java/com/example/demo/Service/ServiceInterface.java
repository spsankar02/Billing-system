package com.example.demo.Service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;
import com.example.demo.model.Order;
import com.example.demo.model.Product;

@Service
public interface ServiceInterface {


	Product create(Product value);
	
	List<Product> findAllProduct();


	String deleteProductdetails(Long productId);

	Product update(Map<String, Object> payload);

	List<Invoice> findAllInvoice();
	
	List<Order> findAllOrder();


}