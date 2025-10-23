package com.eao.musiclab.repository;

import com.eao.musiclab.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}