package com.eao.musiclab.repository;

import com.eao.musiclab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kishor
 * Created on 23/10/2025
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Optional<Album> findByAlbum(String album);
}