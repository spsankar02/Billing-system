package com.example.Billing_software.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Billing_software.Entity.Customer;
import com.example.Billing_software.Repo.Customerrepo;

@Service
public class Serviceclass implements ServiceInterface{
	@Autowired
	private Customerrepo customerrepo;
	
	@Override
	public Customer create(Customer value) {
		return customerrepo.save(value);
	}

}
