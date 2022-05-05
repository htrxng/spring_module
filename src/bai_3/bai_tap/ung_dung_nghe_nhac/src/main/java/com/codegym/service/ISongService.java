package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    void upload(Song song);
    List<Song> getList();
}
