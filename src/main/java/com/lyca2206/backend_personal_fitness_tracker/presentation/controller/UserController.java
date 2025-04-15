package com.lyca2206.backend_personal_fitness_tracker.presentation.controller;

import com.lyca2206.backend_personal_fitness_tracker.application.api.UserService;
import com.lyca2206.backend_personal_fitness_tracker.configuration.utilities.KeyPairHolder;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private KeyPairHolder keyPairHolder;

    @PostMapping("/signUp")
    public void signUp() {
        //TODO: userService.signUp();
    }

    @PostMapping("/signIn")
    public String signIn() {
        //TODO: userService.signIn();
        return Jwts.builder()
                .subject("subject")
                .signWith(keyPairHolder.getPrivate())
                .compact();
    }
}