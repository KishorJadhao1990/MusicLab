package com.eao.musiclab.repository;

import com.eao.musiclab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}