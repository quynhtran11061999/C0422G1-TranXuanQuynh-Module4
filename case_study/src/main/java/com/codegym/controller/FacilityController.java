package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public String goListFacility(Model model,
                                 @PageableDefault(size = 5) Pageable pageable,
                                 @RequestParam Optional<String> keyword){
        String keywordValue = keyword.orElse("");
        model.addAttribute("facilityList",
                this.iFacilityService.findAllByNameContaining(keywordValue,pageable));
        model.addAttribute("keywordValue",keywordValue);
        return "facility/list";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model){
        model.addAttribute("facility", new Facility());
        return "facility/add";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam int id, Model model) {
        model.addAttribute("facility", this.iFacilityService.findById(id));
        return "facility/edit";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        this.iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!!!");
        return "redirect:/facility/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        this.iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công!!!");
        return "redirect:/facility/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        this.iFacilityService.delete(id);
        redirectAttributes.addFlashAttribute("mes", "Xóa thành công!!!");
        return "redirect:/facility/list";
    }
}
