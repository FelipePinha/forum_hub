package com.felipepinha.forumhub.repositories;

import com.felipepinha.forumhub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
