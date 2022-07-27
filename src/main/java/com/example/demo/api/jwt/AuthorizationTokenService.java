package com.example.demo.api.jwt;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class AuthorizationTokenService {

    private final AuthorizationTokenRepository authorizationTokenRepository;

    public AuthorizationToken genereteToken(){
        AuthorizationToken authorizationToken = new AuthorizationToken();
        authorizationToken.setToken(UUID.randomUUID().toString());
        authorizationToken.setCreated(Instant.now());
        return authorizationTokenRepository.save(authorizationToken);
    }

    public void validateToken(String token){
        authorizationTokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid Token!"));
    }

    public void deleteToken(String token){
        authorizationTokenRepository.deleteToken(token);
    }
}
