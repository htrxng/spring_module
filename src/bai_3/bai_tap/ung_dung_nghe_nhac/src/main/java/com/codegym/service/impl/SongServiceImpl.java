package com.codegym.service.impl;

import com.codegym.model.KindOfMusic;
import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.repository.impl.SongRepositoryImpl;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    ISongRepository iSongRepository;

    @Override
    public void upload(Song song) {
         iSongRepository.upload(song);
    }

    @Override
    public List<Song> getList() {
        return iSongRepository.getList();
    }
}
