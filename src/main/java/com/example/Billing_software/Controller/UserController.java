package com.example.Billing_software.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> method(@RequestBody Customer value) {
		try {
			service.create(value);
		return  ResponseEntity.ok().body("User details save successfully");}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user details");
		}
	}
	
	@PostMapping("/retrievecustomerdetails")
	public ResponseEntity<Object> method1(){
		try {
		service.findAll();
		return ResponseEntity.ok().body(service.findAll());}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving user details");
		}
	}
}
