package com.ocheejeh.springmvc.repository;

import com.ocheejeh.springmvc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
