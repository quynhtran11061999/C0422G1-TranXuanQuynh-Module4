package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void add(Music music);

    Music findById(int id);

    void update(Music music);

    void delete(int id);
}
