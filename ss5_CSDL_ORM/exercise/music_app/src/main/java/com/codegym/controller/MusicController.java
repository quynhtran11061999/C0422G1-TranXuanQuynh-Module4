package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("musicList", this.iMusicService.findAll());
        return "/list";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("musicForm", new MusicForm());
        return "/add";
    }

    @GetMapping("/showUpdate")
    public String goUpdatePage(@RequestParam int id, Model model) {
        Music music = this.iMusicService.findById(id);
        MusicForm musicForm = new MusicForm();
        BeanUtils.copyProperties(music, musicForm);
        model.addAttribute("musicForm", musicForm);
        return "/update";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getSongFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getSongFilePath().getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getNameOfSong(), musicForm.getArtistsShow(),
                musicForm.getKindOfMusic(), fileName);
        this.iMusicService.add(music);

        return "redirect:/";
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute MusicForm musicForm) {
        Music oldMusic = this.iMusicService.findById(musicForm.getId());
        MultipartFile multipartFile = musicForm.getSongFilePath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(oldMusic.getId(), oldMusic.getNameOfSong(), oldMusic.getArtistsShow(), oldMusic.getKindOfMusic(), fileName);
        if (music.getSongFilePath().equals("")) {
            music.setSongFilePath(oldMusic.getSongFilePath());
        }
        this.iMusicService.update(music);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        this.iMusicService.delete(id);
        return "redirect:/";
    }
}
