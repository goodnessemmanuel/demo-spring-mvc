package com.ocheejeh.springmvc.services.impl;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.services.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        loadCustomers().forEach((key, value) -> customers.add(value));
        return customers;
    }

    public Map<Integer, Customer> loadCustomers(){
        Map<Integer, Customer> customerMap = new HashMap<>();
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("John");
        customer1.setEmail("john@email.com");
        customer1.setPhone("09089786754");

        customerMap.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setId(1);
        customer2.setName("Johnson");
        customer2.setEmail("jn@email.com");
        customer2.setPhone("09089786904");

        customerMap.put(customer2.getId(), customer2);

        Customer customer3 = new Customer();
        customer3.setId(1);
        customer3.setName("Kemi");
        customer3.setEmail("kmn@email.com");
        customer3.setPhone("08089786901");

        customerMap.put(customer3.getId(), customer3);
        return customerMap;
    }
}
