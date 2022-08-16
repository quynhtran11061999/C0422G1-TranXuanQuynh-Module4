package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @Autowired
    private IConvertService iConvertService;

    @GetMapping("/")
    public String currencyConversion(){
        return "/currency";
    }

    @PostMapping("/convert")
    public String convert (@RequestParam Double usd, Model model){
        Double result = iConvertService.convert(usd);
        model.addAttribute("result",result);
        return "/currency";
    }
}
