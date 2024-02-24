package com.example.Billing_software.Service;

import org.springframework.stereotype.Service;

import com.example.Billing_software.Entity.Customer;

@Service
public interface ServiceInterface {

	Customer create(Customer value);

}
