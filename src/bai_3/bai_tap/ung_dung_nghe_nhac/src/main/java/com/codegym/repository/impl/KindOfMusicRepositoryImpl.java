package com.codegym.repository.impl;

import com.codegym.model.KindOfMusic;
import com.codegym.repository.IKindOfMusicRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KindOfMusicRepositoryImpl implements IKindOfMusicRepository {
    public static List<KindOfMusic> kindOfMusicList = new ArrayList<>();
    static {
        KindOfMusic kindOfMusic1 = new KindOfMusic(1,"pop");
        KindOfMusic kindOfMusic2 = new KindOfMusic(2,"rock");
        KindOfMusic kindOfMusic3 = new KindOfMusic(3,"jazz");
        KindOfMusic kindOfMusic4 = new KindOfMusic(4,"indie");
        KindOfMusic kindOfMusic5= new KindOfMusic(5,"nhac Trinh");
        kindOfMusicList.add(kindOfMusic1);
        kindOfMusicList.add(kindOfMusic2);
        kindOfMusicList.add(kindOfMusic3);
        kindOfMusicList.add(kindOfMusic4);
        kindOfMusicList.add(kindOfMusic5);
    }

    @Override
    public List<KindOfMusic> getList() {
        return kindOfMusicList;
    }
}
