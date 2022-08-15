package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String goDictionary() {
        return "/viewDictionary";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String language, Model model) {
        String result = iDictionaryService.Translate(language);
        model.addAttribute("result", result);
        model.addAttribute("language", language);
        return "/viewDictionary";
    }
}
