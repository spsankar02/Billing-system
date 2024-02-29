package com.example.Billing_software.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Billing_software.Entity.Customer;
import com.example.Billing_software.Entity.Product;
import com.example.Billing_software.Repo.Customerrepo;
import com.example.Billing_software.Repo.Productrepo;

import jakarta.transaction.Transactional;

@Service
public class Serviceclass implements ServiceInterface{
	@Autowired
	private Customerrepo customerrepo;
	@Autowired
	private Productrepo productrepo;
	
	@Override
	public Customer create(Customer value) {
		return customerrepo.save(value);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerrepo.findAll();
	}

	@Override
	public Customer update(Customer value, Long custId) {
        Optional<Customer> customer = customerrepo.findById(custId);
        if (customer.isPresent()) {
        	Customer customer1=customer.get();
            Optional.ofNullable(value.getCustomerName())
            		.ifPresent(customer1::setCustomerName);
            Optional.ofNullable(value.getBeatName())
                    .ifPresent(customer1::setBeatName);
            Optional.ofNullable(value.getAddress())
                    .ifPresent(customer1::setAddress);
            Optional.ofNullable(value.getPhoneNo())
                    .ifPresent(customer1::setPhoneNo);
            Optional.ofNullable(value.getGstNo())
                    .ifPresent(customer1::setGstNo);
            customerrepo.save(customer1);
            return customer1;
        }else {
            throw new IllegalArgumentException("Customer details not found");
        }
	}

	@Transactional
	public String deleteCustomerdetails(Long custId) {
        Optional<Customer> customer = customerrepo.findById(custId);
        if(customer.isPresent()) {
        	customerrepo.deleteById(custId);
        	return "Customer details deleted successfully";
        }else {
        	throw new IllegalArgumentException("Customer details is not found");
        }
	}

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
