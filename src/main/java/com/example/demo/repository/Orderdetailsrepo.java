package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderDetails;

@Repository
public interface Orderdetailsrepo extends JpaRepository<OrderDetails, Long>{

	List<OrderDetails> findByProductId(Long id);

}
