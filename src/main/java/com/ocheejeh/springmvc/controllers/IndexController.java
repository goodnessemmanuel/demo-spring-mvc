package com.ocheejeh.springmvc.controllers;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/customers")
    public String showCustomers(Model model){
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    @RequestMapping("/customer/{id}")
    public String showCustomers(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @PostMapping("/addcustomer")
    public String addCustomer(Customer customer){
        Customer $customer = customerService.addCustomer(customer);
        return "redirect:/customer/" + $customer.getId();
    }


    @RequestMapping("/new-customer")
    public String showCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "new-customer";
    }

    /**
     *
     * @param id get the target customer to be edited
     * @param model to edit customer previous detail
     * @return
     */
    @RequestMapping("/edit-customer/{id}")
    public String showEditCustomerForm(@PathVariable Integer id, Model model){
        Customer $customer = customerService.getCustomerById(id);
        model.addAttribute("customer", $customer);
        return "new-customer";
    }

    @RequestMapping("/delete-customer/{id}")
    public String deleteCustomerDetail(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
