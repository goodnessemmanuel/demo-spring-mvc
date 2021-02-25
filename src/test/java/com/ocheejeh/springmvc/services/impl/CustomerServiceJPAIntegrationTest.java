/**
 * test to ensure database is
 * integrated properly.
 * dont start tomcat server
 */
package com.ocheejeh.springmvc.services.impl;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("jpa")//set profile here to ensure integration test is independent of application.properties file
public class CustomerServiceJPAIntegrationTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
   public void testListAllCustomers(){
        List<Customer> customers = customerService.listAllCustomers();
        assertEquals(4, customers.size());
    }
}
