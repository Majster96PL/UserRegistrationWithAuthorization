package com.example.demo.api;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserRequest;
import com.example.demo.user.UserRole;
import com.example.demo.web.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class ApiService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void register(UserRequest request){
        User registerUser = new User();
        registerUser.setFirstname(request.getFirstname());
        registerUser.setLastname(request.getLastname());
        registerUser.setUsername(request.getUsername());
        registerUser.setPassword((passwordEncoder
                .bCryptPasswordEncoder().encode(request.getPassword())));
        registerUser.setRole(UserRole.USER);
        registerUser.setCreated(Instant.now());
        registerUser.setEnabled(false);
        userRepository.save(registerUser);

    }
}
