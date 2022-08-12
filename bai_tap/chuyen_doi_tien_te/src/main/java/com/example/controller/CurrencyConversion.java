package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @GetMapping("/")
    public String currencyConversion(){
        return "/currency";
    }

    @PostMapping("/convert")
    public String convert (@RequestParam Double usd, Model model){
        double result;
        result = usd * 23000;
        model.addAttribute("result",result);
        return "/currency";
    }
}
