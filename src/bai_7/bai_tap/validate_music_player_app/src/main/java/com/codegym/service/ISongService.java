package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    void save(Song song);

    List<Song> findAll();

    Song findById(String id);
}
