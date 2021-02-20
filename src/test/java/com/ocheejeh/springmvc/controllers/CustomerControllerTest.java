package com.ocheejeh.springmvc.controllers;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CustomerControllerTest {
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this); //initialize controller and mocks
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    @DisplayName("list all customers route")
    void testCustomerList() throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());
        //for this specific mockito operation, tell the code stub to return this customers list
        when(customerService.listAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/customers/"))
                .andExpect(status().isOk())
                .andExpect(view().name("customers/index"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }

    @Test
    @DisplayName("display customer given the customer id")
    void showCustomerWithId() throws Exception {
        int id = 1;
        when(customerService.getCustomerById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customers/view-customer/1"))
                .andExpect(view().name("customers/customer"))
                .andExpect(model().attribute("customer", instanceOf((Customer.class))));
    }

    @Test
    @DisplayName("edit customer given the customer id")
    void editCustomerWithId() throws Exception {
        int id = 1;
        when(customerService.getCustomerById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customers/edit-customer/1"))
                .andExpect(view().name("customers/new-customer"))
                .andExpect(model().attribute("customer", instanceOf((Customer.class))));
    }

    @Test
    @DisplayName("should display add new customer form")
    void showNewCustomerForm() throws Exception {
        //customer service should not be called here
        verifyNoInteractions(customerService);
        mockMvc.perform(get("/customers/add"))
                .andExpect(view().name("customers/new-customer"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    @DisplayName("Should add new customer")
    void shouldAddNewCustomer(){
        String name = "James";
        String email = "James@gmail.com";
        String phone = "0904534234";

    }
}