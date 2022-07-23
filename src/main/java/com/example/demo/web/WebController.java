package com.example.demo.web;

import com.example.demo.api.ApiService;
import com.example.demo.user.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class WebController {
    private final ApiService apiService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest userRequest){
        apiService.register(userRequest);
        return new ResponseEntity<>("User registration successful", HttpStatus.OK);
    }
}
