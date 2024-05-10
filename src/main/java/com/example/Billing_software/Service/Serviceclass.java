package com.example.demo.Service;


import java.util.List;
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
	public Product update(Product value, Long productId) {
		Optional<Product> product = productrepo.findById(productId);
		if(product.isPresent()) {
			Product product1=product.get();
            Optional.ofNullable(value.getHsnNo())
                    .ifPresent(product1::setHsnNo);
            Optional.ofNullable(value.getMrp())
                    .ifPresent(product1::setMrp);
            Optional.ofNullable(value.getProductName())
                    .ifPresent(product1::setProductName);
            Optional.ofNullable(value.getCurrentStock())
                    .ifPresent(product1::setCurrentStock);
            Optional.ofNullable(value.getRetailRate())
                    .ifPresent(product1::setRetailRate);
            Optional.ofNullable(value.getWholesaleRate())
                    .ifPresent(product1::setWholesaleRate);
            Optional.ofNullable(value.getMinQty())
                    .ifPresent(product1::setMinQty);
            Optional.ofNullable(value.getMaxQty())
                    .ifPresent(product1::setMaxQty);
            Optional.ofNullable(value.getGst())
            		.ifPresent(product1::setGst);
           productrepo.save(product1); 
           return product1;
		}else {
            throw new IllegalArgumentException("Product details is not found");
        	}
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
