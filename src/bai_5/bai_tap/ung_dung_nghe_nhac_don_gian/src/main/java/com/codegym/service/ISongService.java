package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getListSong();

    void addSong(Song song);

    Song findById(Integer id);

    void remove(int id);

    void update( Song song);
}
