package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> getListSong() {
        return iSongRepository.getListSong();
    }

    @Override
    public void addSong(Song song) {
        iSongRepository.addSong(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        iSongRepository.remove(id);
    }

    @Override
    public void update( Song song) {
        iSongRepository.update(song);
    }
}
