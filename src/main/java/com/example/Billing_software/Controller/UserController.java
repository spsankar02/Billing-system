package com.example.Billing_software.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Billing_software.Entity.Customer;
import com.example.Billing_software.Service.ServiceInterface;

@RestController
@RequestMapping("/billing_system")
public class UserController {
	@Autowired
	private ServiceInterface service;
	
	@PostMapping("/addcustomerdetails")
	public Customer method(@RequestBody Customer value) {
		return service.create(value);
	}
}
