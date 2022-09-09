package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String goListCustomer(Model model,
                                 @PageableDefault(size = 5) Pageable pageable,
                                 @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        model.addAttribute("customerList",
                this.iCustomerService.findAllByNameContaining(keywordValue, pageable));
        model.addAttribute("keywordValue", keywordValue);
        return "customer/list";
    }

    @ModelAttribute(value = "customerTypeList")
    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerTypeList = this.customerTypeService.findAll();
        return customerTypeList;
    }
    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam int id, Model model) {
        model.addAttribute("customer", this.iCustomerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute @Valid CustomerDto customerDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!!!");
        return "redirect:/customer/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công!!!");
        return "redirect:/customer/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        this.iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("mes", "Xóa thành công!!!");
        return "redirect:/customer/list";
    }
}
