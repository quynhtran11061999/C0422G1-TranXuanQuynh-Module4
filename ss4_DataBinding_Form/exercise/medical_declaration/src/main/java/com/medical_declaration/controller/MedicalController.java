package com.medical_declaration.controller;

import com.medical_declaration.model.Medical;
import com.medical_declaration.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalController {

    @Autowired
    private IMedicalService iMedicalService;

    @GetMapping("/")
    public String viewMedical(Model model) {
        List<String> gender = this.iMedicalService.gender();
        List<String> nationality = this.iMedicalService.nationality();
        List<String> vehicle = this.iMedicalService.vehicle();
        List<String> day = this.iMedicalService.day();
        List<String> month = this.iMedicalService.month();
        List<String> year = this.iMedicalService.year();
        model.addAttribute("gender",gender);
        model.addAttribute("nationality",nationality);
        model.addAttribute("vehicle",vehicle);
        model.addAttribute("day",day);
        model.addAttribute("month",month);
        model.addAttribute("year",year);
        model.addAttribute("medical", new Medical());
        return "/add";
    }

    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute("displayList",iMedicalService.displayList());
        return "/list";
    }

    @PostMapping("/save")
    public String goAdd(@ModelAttribute Medical medical, RedirectAttributes redirectAttributes){
      iMedicalService.add(medical);
      redirectAttributes.addFlashAttribute("mess","Thêm thành công");
      return "redirect:/showList";
    }


}
