package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping("/home")
    public String goHome(Model model) {
        model.addAttribute("songList", iSongService.findAll());
        return "list";
    }

    @GetMapping(value = "/add")
    public String goCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping(value = "/addToList")
    public String addToList(@ModelAttribute @Validated SongDto songDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "add " + " successful!");
            return "redirect:/home";
        }
    }

    @GetMapping(value = "/{id}/editForm")
    public String goEditForm(Model model, @PathVariable String id) {
        Song song = iSongService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "/edit";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute @Validated SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "update successful! ");
            return "redirect:/home";
        }
    }
}
