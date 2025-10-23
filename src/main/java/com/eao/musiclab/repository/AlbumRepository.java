package com.eao.musiclab.repository;

import com.eao.musiclab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kishor
 * Created on 23/10/2025
 */
public interface AlbumRepository extends JpaRepository<Album, Integer> {
}