package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery("select m from Music m", Music.class);
        return query.getResultList();
    }

    @Override
    public void add(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.persist(music);

        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        return BaseRepository.entityManager.find(Music.class, id);
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.merge(music);

        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.remove(findById(id));

        entityTransaction.commit();
    }
}
