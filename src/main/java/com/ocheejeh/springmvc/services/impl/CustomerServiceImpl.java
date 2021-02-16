package com.ocheejeh.springmvc.services.impl;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    Map<Integer, Customer> customerMap;

    public CustomerServiceImpl() {
        this.loadCustomers();
    }

    /**
     *
     * @return array list of all values in customer's map
     */
    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerMap.get(id);
    }

    public void loadCustomers(){
        customerMap = new HashMap<>();
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("John");
        customer1.setEmail("john@email.com");
        customer1.setPhone("09089786754");

        customerMap.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Johnson");
        customer2.setEmail("jn@email.com");
        customer2.setPhone("09089786904");

        customerMap.put(customer2.getId(), customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("Kemi");
        customer3.setEmail("kmn@email.com");
        customer3.setPhone("08089786901");

        customerMap.put(customer3.getId(), customer3);
    }
}
