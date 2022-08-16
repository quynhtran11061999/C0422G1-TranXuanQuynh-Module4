package com.sandwich.controller;

import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService iSandwichService;

    @GetMapping("/")
    public String goSandwich(Model model) {
        List<String> stringList = iSandwichService.findAll();
        model.addAttribute("stringList", stringList);
        return "/sandwich";
    }

    @PostMapping("/condiments")
    public String displayCondiments(@RequestParam String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        List<String> stringList = iSandwichService.findAll();
        model.addAttribute("stringList", stringList);
        return "/sandwich";
    }
}
