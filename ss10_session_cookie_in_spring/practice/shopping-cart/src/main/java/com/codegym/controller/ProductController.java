package com.codegym.controller;

import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String goHome(){
        this.iProductService.findAll();
        return "home";
    }

}
