package com.ocheejeh.springmvc.services.impl;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.repository.CustomerRepository;
import com.ocheejeh.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa")
public class CustomerServiceImplJPA implements CustomerService {

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = this.getCustomerById(id);
        customerRepository.delete(customer);
    }
}
