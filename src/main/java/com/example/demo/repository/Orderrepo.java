package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Billing;
import com.example.demo.model.Order;

@Repository
public interface Orderrepo extends JpaRepository<Order, Long>{

//	Billing findByUser(Object object);

}
