package com.medical_declaration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicalController {
    @GetMapping("/")
    public String viewMedical(){
        return "/home";
    }
}
