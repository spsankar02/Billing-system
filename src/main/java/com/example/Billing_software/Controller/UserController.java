package com.example.Billing_software.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Billing_software.Entity.Customer;
import com.example.Billing_software.Entity.OrderDetails;
import com.example.Billing_software.Entity.Orders;
import com.example.Billing_software.Entity.Product;
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
		service.findAllCustomer();
		return ResponseEntity.ok().body(service.findAllCustomer());}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving user details");
		}
	}
	
	@PostMapping("/updatecustomerdetails/{customerId}")
	public ResponseEntity<Object> method2(@RequestBody Customer value,@PathVariable Long customerId){
		try {
			service.update(value,customerId);
			return ResponseEntity.ok().body("User details updated successfully");
		}catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user details: "+e.getMessage());
		}
	}
	
	@DeleteMapping("/deletecustomerdetails/{customerId}")
	public ResponseEntity<Object> method3(@PathVariable Long customerId){
		try {
		service.deleteCustomerdetails(customerId);
		return ResponseEntity.ok().body("User details deleted successfully");}
		catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user details: "+e.getMessage());
        }
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
	
	@PostMapping("/retrieveproductdetails")
	public ResponseEntity<Object> method5(){
		try {
		service.findAllProduct();
		return ResponseEntity.ok().body(service.findAllProduct());}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving product details");
		}
	}
	
	@PostMapping("/updateproductdetails/{productId}")
	public ResponseEntity<Object> method6(@RequestBody Product value,@PathVariable Long productId){
		try {
			service.update(value,productId);
			return ResponseEntity.ok().body("Product details updated successfully");
		}catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Product details: "+e.getMessage());
		}
	}
	
	@DeleteMapping("/deleteproductdetails/{productId}")
	public ResponseEntity<Object> method7(@PathVariable Long productId){
		try {
		service.deleteProductdetails(productId);
		return ResponseEntity.ok().body("Product details deleted successfully");}
		catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Product details: "+e.getMessage());
        }
	}
	
	@PostMapping("/addorderdetails")
	public ResponseEntity<Object> method8(@RequestBody Orders orders){
		try {
            service.create(orders);
        return  ResponseEntity.ok().body("Order details save successfully");}
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order details");
        }
	}
	
	@PostMapping("/addproductsfororder")
	public ResponseEntity<Object> method9(@RequestBody OrderDetails orders){
		try {
			service.create(orders);
			return ResponseEntity.ok().body("productlist details save successfully");}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating productlist details");
		}
	}
	
}
