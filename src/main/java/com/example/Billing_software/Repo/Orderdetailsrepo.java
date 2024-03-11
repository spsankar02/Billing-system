package com.example.Billing_software.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Billing_software.Entity.OrderDetails;

public interface Orderdetailsrepo extends JpaRepository<OrderDetails, Long>{

}
