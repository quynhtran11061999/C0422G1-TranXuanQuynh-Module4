package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void add(Music music);

    Music findById(int id);

    void update(Music music);

    void delete(int id);
}
