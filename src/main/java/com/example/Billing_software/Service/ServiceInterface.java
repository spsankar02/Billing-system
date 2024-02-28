package com.example.Billing_software.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Billing_software.Entity.Customer;

@Service
public interface ServiceInterface {

	Customer create(Customer value);

	List<Customer> findAll();

}
