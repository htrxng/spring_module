package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("songs")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping(value = "list")
    public String showList(Model model) {
        model.addAttribute("songList",this.iSongService.getListSong());
        return "list";
    }

    @GetMapping(value = "/upload")
    public String goCreate(Model model) {
        model.addAttribute("song",new Song());
        return "/create";
    }

    @PostMapping(value = "/addToList")
    public String addToList(Song song, RedirectAttributes redirectAttributes){
        iSongService.addSong(song);
        redirectAttributes.addFlashAttribute("success","add successfully!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/deleteForm")
    public String goDelete(@PathVariable Integer id,Model model) {
        model.addAttribute("song",this.iSongService.findById(id));
        return "delete";
    }
    @PostMapping(value = "delete")
    public String delete(Song song,RedirectAttributes redirectAttributes){
        iSongService.remove(song.getId());
        redirectAttributes.addFlashAttribute("success","delete successfully!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/editForm")
    public String goEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("song",this.iSongService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(Song song){
        iSongService.update(song);
        return "redirect:/list";
    }
    @GetMapping("/{id}/detailForm")
    public String goDetail(@PathVariable int id,Model model) {
        model.addAttribute("song",iSongService.findById(id));
        return "detail";
    }


















}
