package com.codegym.controller;

import com.codegym.model.Word;
import com.codegym.service.IWordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IWordService wordService;
    @GetMapping(value = "/search")
    public String searchWord(@RequestParam String word, Model model) {
      Word foundedWord =  wordService.findWord(word);
      model.addAttribute("word",foundedWord);
      return "search";
    }
}
