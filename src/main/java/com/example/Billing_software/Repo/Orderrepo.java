package com.example.Billing_software.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Billing_software.Entity.Orders;

@Repository
public interface Orderrepo extends JpaRepository<Orders, Long> {

}
