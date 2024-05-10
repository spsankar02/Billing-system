package com.example.demo.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public interface ServiceInterface {


	Product create(Product value);
	
	List<Product> findAllProduct();

	Product update(Product value, Long productId);

	String deleteProductdetails(Long productId);


}