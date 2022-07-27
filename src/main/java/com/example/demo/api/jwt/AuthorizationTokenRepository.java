package com.example.demo.api.jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationTokenRepository extends JpaRepository<AuthorizationToken, Long> {
    Optional<AuthorizationToken> findByToken(String token);
    void deleteToken(String token);
}
