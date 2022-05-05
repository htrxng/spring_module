package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {
    private static List<Song> songList = new ArrayList<>();
    static {
        Song song1 = new Song("Tuoi Da Buon","Khanh Ly",5,"https://zingmp3.vn/bai-hat/Tuoi-Da-Buon-Khanh-Ly/ZWZAA7F0.html");
        Song song2 = new Song("Tro ve","Buc Tuong",2,"https://zingmp3.vn/bai-hat/Tro-Ve-Buc-Tuong/ZWZ9Z0DB.html");
        Song song3 = new Song("Co em doi bong vui","Chillies",1,"https://zingmp3.vn/bai-hat/Co-Em-Doi-Bong-Vui-Chillies/ZZZEWDOF.html");
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
    }


    @Override
    public List<Song> getList() {
        return songList;
    }

    @Override
    public void upload(Song song) {
         songList.add(song);
    }
}
