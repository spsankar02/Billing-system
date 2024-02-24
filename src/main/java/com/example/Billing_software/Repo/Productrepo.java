package com.example.Billing_software.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Billing_software.Entity.Product;

@Repository
public interface Productrepo extends JpaRepository<Product, Long>{

}
