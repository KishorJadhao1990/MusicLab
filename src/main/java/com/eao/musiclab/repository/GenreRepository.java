package com.eao.musiclab.repository;

import com.eao.musiclab.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kishor
 * Created on 23/10/2025
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByName(String genre);
}