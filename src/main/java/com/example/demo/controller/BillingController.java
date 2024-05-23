package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;	



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.Serviceclass;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Billing;
import com.example.demo.model.Invoice;
import com.example.demo.model.Product;
import com.example.demo.repository.BillingRepository;
import com.example.demo.repository.Productrepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class BillingController {

	@Autowired
	private BillingRepository billingRepository;

	@Autowired
	private Productrepo productrepo;

	@Autowired
	private Serviceclass service;

	//get all billing

	@GetMapping("/getalluserslist")
	public List<Billing> getAllBilling(){
		return billingRepository.findAll();
	}

	//create billing rest api

	@PostMapping("/createuser")
	public Billing createBilling(@RequestBody Billing billing) {
		return billingRepository.save(billing);
	}

	//get billing by id rest api

	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<Billing> getBillingById(@PathVariable Long id){
		Billing billing = billingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Billing not exist with id :" + id));
		return ResponseEntity.ok(billing);
	}



	@PostMapping("/updateuser/")
	public ResponseEntity<Billing> updateBilling(@RequestBody Map<String, Object> payload){
		String idString = (String) payload.get("id");
		Object pincodeValue = payload.get("pincode");
		String pincodeString;

		if (pincodeValue instanceof Integer) {
			pincodeString = String.valueOf(pincodeValue);
		} else if (pincodeValue instanceof String) {
			pincodeString = (String) pincodeValue;
		} else {
			throw new IllegalArgumentException("Invalid pincode value: " + pincodeValue);
		}
		Object phoneNoValue = payload.get("phoneNo");
		String phoneNo;

		if (phoneNoValue instanceof Long) {
			phoneNo = String.valueOf(phoneNoValue);
		} else if (phoneNoValue instanceof String) {
			phoneNo = (String) phoneNoValue;
		} else {
			throw new IllegalArgumentException("Invalid phoneNo value: " + phoneNoValue);
		}
		Long id = Long.parseLong(idString);
		Billing billing = billingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Billing not exist with id :" + id));
		billing.setCustomerName((String) payload.get("customerName"));
		billing.setEmailAddress((String) payload.get("emailAddress"));
		billing.setAddress((String) payload.get("address"));
		billing.setCity((String) payload.get("city"));
		billing.setState((String) payload.get("state"));
		billing.setPincode(Long.parseLong(pincodeString));
		billing.setCountry((String) payload.get("country"));
		billing.setRole((String) payload.get("role"));
		billing.setCompanyName((String) payload.get("companyName"));
		billing.setPhoneNo(Long.parseLong(phoneNo));    
		Billing updatedBilling = billingRepository.save(billing);
		return ResponseEntity.ok(updatedBilling);
	}


	//delete billing rest api 

	@PostMapping("/deleteuser/")
	public ResponseEntity<Map<String, Boolean>> deleteBilling(@RequestBody Map<String, Long> payload){
		Long id = payload.get("id"); // Extract the ID from the payload
		Billing billing = billingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Billing not exist with id :" + id));
		billingRepository.delete(billing);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}



	@PostMapping("/addproductdetails")
	public ResponseEntity<Object> method4(@RequestBody Product value) {
		try {
			service.create(value);
			return  ResponseEntity.ok().body("Product details save successfully");}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating product details");
		}
	}

	@GetMapping("/getproductbyid/{id}")
	public ResponseEntity<Product> getproductById(@PathVariable Long id){
		Product billing = productrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Billing not exist with id :" + id));
		return ResponseEntity.ok(billing);
	}


	@GetMapping("/retrieveproductdetails")
	public ResponseEntity<Object> method5(){
		try {
			service.findAllProduct();
			return ResponseEntity.ok().body(service.findAllProduct());}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving product details");
		}
	}

	@PostMapping("/updateproductdetails/")
	public ResponseEntity<Object> method6(@RequestBody Map<String, Object> payload){
		try {
			System.out.println(payload);
			Product product=service.update(payload);
			return ResponseEntity.ok(product);
		}catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Product details: "+e.getMessage());
		}
	}

	@PostMapping("/deleteproductdetails/")
	public ResponseEntity<Map<String,Boolean>> method7(@RequestBody Map<String,Long> payload){
		Long productId=payload.get("id");
		service.deleteProductdetails(productId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/createinvoice/")
	public ResponseEntity<Object> method8(@RequestBody Map<String, Object> payload){
		try {
			service.createInvoice(payload);
			return ResponseEntity.ok().body("Invoice created successfully");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Invoice details: "+e.getMessage());
		}
	}
	
	@GetMapping("/retrieveinvoicedetails")
	public ResponseEntity<List<Invoice>> method9() {
	    try {
	    	System.out.println("try");
	        List<Invoice> invoices = service.findAllInvoice();
	        return ResponseEntity.ok().body(invoices);
	    } catch(Exception e) {
	    	System.out.println("catch");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body(Collections.emptyList()); // Empty list or null, depending on your requirements
	    }
	}



}





