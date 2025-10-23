package com.eao.musiclab.repository;

import com.eao.musiclab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kishor
 * Created on 23/10/2025
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}