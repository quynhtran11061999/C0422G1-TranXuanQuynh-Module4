package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> createCart() {
        return new HashMap<>();
    }

    @GetMapping("/")
    public String goProductList(Model model) {
        model.addAttribute("productList", this.iProductService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String goDetailPage(Model model, @RequestParam Long id) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "detail";
    }


    @GetMapping("/cart")
    public String goCart(Model model, @SessionAttribute("cart") Map<Product, Integer> cart) {
        double total = this.iCartService.getTotal(cart);
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "cart";
    }

    @GetMapping("/add")
    public String add(@RequestParam Long id,
                             @SessionAttribute("cart") Map<Product, Integer> cart) {
        Product product = this.iProductService.findById(id);
        this.iCartService.add(cart, product);
        return "redirect:/cart";
    }
}
