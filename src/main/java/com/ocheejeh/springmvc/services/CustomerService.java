package com.ocheejeh.springmvc.services;

import com.ocheejeh.springmvc.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer addCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
