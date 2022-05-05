package com.codegym.service.impl;

import com.codegym.model.KindOfMusic;
import com.codegym.repository.IKindOfMusicRepository;
import com.codegym.repository.impl.KindOfMusicRepositoryImpl;
import com.codegym.service.IKindOfMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindOfMusicServiceImpl implements IKindOfMusicService {
    @Autowired
    IKindOfMusicRepository iKindOfMusicRepository;

    @Override
    public List<KindOfMusic> getList() {
        return iKindOfMusicRepository.getList();
    }
}
