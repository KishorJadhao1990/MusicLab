package com.eao.musiclab.repository;

import com.eao.musiclab.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kishor
 * Created on 23/10/2025
 */
@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {
}