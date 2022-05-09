package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    @Override
    public List<Song> getListSong() {
        TypedQuery<Song> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from Song s",Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void addSong(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(Integer id) {
        TypedQuery<Song> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from Song s where s.id = :id",Song.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(this.findById(id));
        entityTransaction.commit();
    }

    @Override
    public void update(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }
}
