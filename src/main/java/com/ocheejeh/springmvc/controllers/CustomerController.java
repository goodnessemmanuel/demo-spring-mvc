package com.ocheejeh.springmvc.controllers;

import com.ocheejeh.springmvc.model.Customer;
import com.ocheejeh.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers/index";
    }

    @RequestMapping("/view-customer/{id}")
    public String getCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customers/customer";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer){
        Customer $customer = customerService.addCustomer(customer);
        return "redirect:/customers/view-customer/" + $customer.getId();
    }


    @RequestMapping("/add")
    public String showNewCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customers/new-customer";
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
        return "customers/new-customer";
    }

    @RequestMapping("/delete-customer/{id}")
    public String deleteCustomerDetail(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers/";
    }

}
