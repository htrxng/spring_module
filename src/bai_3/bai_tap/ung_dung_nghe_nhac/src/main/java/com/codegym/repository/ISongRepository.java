package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> getList();

    void upload(Song song);
}
