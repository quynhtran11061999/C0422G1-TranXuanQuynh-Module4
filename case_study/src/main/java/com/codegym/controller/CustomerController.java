package com.codegym.controller;

import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerServicel;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String goListCustomer(Model model){
        model.addAttribute("customerList",this.iCustomerServicel.findAll());
        return "customer/list";
    }
}
