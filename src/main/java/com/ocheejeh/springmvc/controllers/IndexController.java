package com.ocheejeh.springmvc.controllers;

import com.ocheejeh.springmvc.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    CustomerService customerService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/customers")
    public String showCustomers(Model model){
        model.addAttribute("customers", customerService.getCustomers());
        return "customers";
    }
}
