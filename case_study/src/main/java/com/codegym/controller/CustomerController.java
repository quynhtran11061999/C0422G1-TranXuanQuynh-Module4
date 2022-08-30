package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerServicel;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String goListCustomer(Model model){
        List<Customer> customers = this.iCustomerServicel.findAll();
        model.addAttribute("customerList",this.iCustomerServicel.findAll());
        return "customer/list";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/add";
    }
    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam int id,Model model){
        model.addAttribute("customer",this.iCustomerServicel.findById(id));
        return "customer/edit";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        this.iCustomerServicel.save(customer);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công!!!");
        return "redirect:/customer/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        this.iCustomerServicel.save(customer);
        redirectAttributes.addFlashAttribute("mess","Sửa thông tin thành công!!!");
        return "redirect:/customer/list";
    }
}
