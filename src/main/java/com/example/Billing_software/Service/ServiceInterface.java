package com.example.Billing_software.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Billing_software.Entity.Customer;
import com.example.Billing_software.Entity.OrderDetails;
import com.example.Billing_software.Entity.Orders;
import com.example.Billing_software.Entity.Product;

@Service
public interface ServiceInterface {

	Customer create(Customer value);

	List<Customer> findAllCustomer();

	Customer update(Customer value, Long customerId);

	String deleteCustomerdetails(Long customerId);

	Product create(Product value);
	
	List<Product> findAllProduct();

	Product update(Product value, Long productId);

	String deleteProductdetails(Long productId);

	Orders create(Orders orders);

	OrderDetails create(OrderDetails orders);

}
