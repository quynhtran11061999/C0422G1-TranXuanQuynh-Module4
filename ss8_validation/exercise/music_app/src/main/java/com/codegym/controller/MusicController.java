package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("musicList", this.iMusicService.findAll());
        return "/list";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("music", new Music());
        return "/add";
    }

    @GetMapping("/showUpdate")
    public String goUpdate(@RequestParam int id, Model model) {
        model.addAttribute("music", this.iMusicService.findById(id));
        return "/update";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("music") @Valid MusicDto musicDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/add";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Đăng kí thành công!!!");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "music") @Valid MusicDto musicDto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/update";
        }
        Music music = new Music();
        music.setId(musicDto.getId());
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        return "redirect:/";
    }
}
