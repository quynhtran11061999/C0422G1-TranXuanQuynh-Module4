package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String goList(Model model){
        model.addAttribute("blogList",this.iBlogService.findAll());
        return "/list";
    }

    @GetMapping("/showAdd")
    public String goAdd(Model model){
        model.addAttribute("blog",new Blog());
        return "/add";
    }

    @GetMapping("/showUpdate")
    public String goUpdate(@RequestParam int id, Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "/update";
    }

    @GetMapping("/showDetail")
    public String goDetail(@RequestParam int id, Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "/detail";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công!!!");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","Sửa thông tin thành công!!!");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        this.iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("mes","Xóa thành công!!!");
        return "redirect:/";
    }
}
