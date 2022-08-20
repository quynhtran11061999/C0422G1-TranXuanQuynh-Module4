package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return this.iMusicRepository.findAll();
    }

    @Override
    public void add(Music music) {
        this.iMusicRepository.add(music);
    }

    @Override
    public Music findById(int id) {
        return this.iMusicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        this.iMusicRepository.update(music);
    }

    @Override
    public void delete(int id) {
        this.iMusicRepository.delete(id);
    }
}
