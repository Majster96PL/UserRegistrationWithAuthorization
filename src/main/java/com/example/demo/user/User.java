package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    @NotBlank(message = "Firstname is required")
    private String firstname;
    @Column(name = "lastname")
    @NotBlank(message = "Lastname is required")
    private String lastname;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private Instant created;
    private boolean enabled;
}
