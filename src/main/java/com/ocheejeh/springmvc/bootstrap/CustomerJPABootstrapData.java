package com.ocheejeh.springmvc.bootstrap;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomerJPABootstrapData implements ApplicationListener<ContextRefreshedEvent> {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadCustomers();
    }


    private void loadCustomers(){
        Customer customer1 = new Customer();
        customer1.setName("John");
        customer1.setEmail("john@email.com");
        customer1.setPhone("09089786754");

        customerService.addCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Johnson");
        customer2.setEmail("jn@email.com");
        customer2.setPhone("09089786904");

        customerService.addCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setName("Kemi");
        customer3.setEmail("kmn@email.com");
        customer3.setPhone("08089786901");

        customerService.addCustomer(customer3);

        Customer customer4 = new Customer();
        customer4.setName("Wills");
        customer4.setEmail("willthompson@ymail.com");
        customer4.setPhone("08066786903");

        customerService.addCustomer(customer4);
    }
}
