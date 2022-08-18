package com.product_management.controller;

import com.product_management.model.Product;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("displayList", iProductService.displayList());
        return "/list";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @PostMapping("/add")
    public String goAdd(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.add(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String goUpdate(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin sản phẩm thành công");
        this.iProductService.update(product.getId(), product);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String goDelete(@RequestParam int id) {
        this.iProductService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/showDetail")
    public String goDetail(@RequestParam int id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/detail";
    }

    @GetMapping("/showSearchByName")
    public String goSearchByName(@RequestParam String productName, Model model){
        model.addAttribute("displayList",this.iProductService.searchByName(productName));
        return "/list";
    }
}
