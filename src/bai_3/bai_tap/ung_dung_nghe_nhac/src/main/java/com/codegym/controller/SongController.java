package com.codegym.controller;

import com.codegym.model.KindOfMusic;
import com.codegym.model.Song;
import com.codegym.service.IKindOfMusicService;
import com.codegym.service.ISongService;
import com.codegym.service.impl.KindOfMusicServiceImpl;
import com.codegym.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
    @Autowired
    private IKindOfMusicService iKindOfMusicService;

    @GetMapping(value = "/list")
    public String goSongList(Model model) {
        model.addAttribute("songList",this.iSongService.getList());
        model.addAttribute("kindOfMusicList",this.iKindOfMusicService.getList());
        return "list";
    }
    @GetMapping("create")
    public String goCreate(Model model) {
        model.addAttribute("song",new Song());
        return "create";
    }

    @PostMapping(value = "upload")
    public String uploadSong(@ModelAttribute Song song,
                             RedirectAttributes redirectAttributes) {
        this.iSongService.upload(song);

        return "redirect:/list";
    }
}
