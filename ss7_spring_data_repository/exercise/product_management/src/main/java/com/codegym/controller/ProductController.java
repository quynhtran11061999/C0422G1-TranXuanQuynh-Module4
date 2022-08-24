package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String goList(Model model,
                         @PageableDefault(size = 3) Pageable pageable,
                         @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        model.addAttribute("displayList",
                this.iProductService.findAllByNameContaining(keywordValue, pageable));
        model.addAttribute("keywordValue", keywordValue);
        return "/list";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/update";
    }

    @GetMapping("/showDetail")
    public String goDetail(@RequestParam int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/detail";
    }

    @PostMapping("/add")
    public String goAdd(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!!!");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String goUpdate(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin sản phẩm thành công!!!");
        this.iProductService.save(product);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String goDelete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        this.iProductService.delete(id);
        redirectAttributes.addFlashAttribute("mes", "Xóa thành công!!!");
        return "redirect:/";
    }
}
