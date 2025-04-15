package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.configuration.utilities.KeyPairHolder;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

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
                .issuedAt(Date.from(
                        Instant.now()
                ))
                .expiration(Date.from(
                        Instant.now().plusSeconds(3600)
                ))
                .signWith(keyPairHolder.getPrivate())
                .compact();
    }
}