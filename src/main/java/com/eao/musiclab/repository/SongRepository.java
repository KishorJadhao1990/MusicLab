package com.eao.musiclab.repository;

import com.eao.musiclab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}