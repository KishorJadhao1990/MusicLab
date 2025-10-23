package com.eao.musiclab.repository;

import com.eao.musiclab.model.LikeDislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Long> {
}