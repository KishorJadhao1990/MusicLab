package com.eao.musiclab.repository;

import com.eao.musiclab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kishor
 * Created on 23/10/2025
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist findByUsername(String artist);
}