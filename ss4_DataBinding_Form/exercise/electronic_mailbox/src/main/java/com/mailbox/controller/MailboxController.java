package com.mailbox.controller;

import com.mailbox.model.Mailbox;
import com.mailbox.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MailboxController {
    @Autowired
    private IMailboxService iMailboxService;

    @GetMapping("/")
    public String mailBox(Model model) {
        List<String> languagesList = iMailboxService.languages();
        model.addAttribute("languagesList", languagesList);
        List<Integer> pageSizeList = iMailboxService.pageSize();
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("mailBox", new Mailbox());
        return "/home";
    }

    @PostMapping("/chooseMailbox")
    public String chooseMailbox(@ModelAttribute Mailbox mailbox, Model model) {
        model.addAttribute("mailbox", mailbox);
        return "/list";
    }
}
