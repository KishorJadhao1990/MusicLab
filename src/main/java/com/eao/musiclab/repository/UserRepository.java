package com.eao.musiclab.repository;

import com.eao.musiclab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}