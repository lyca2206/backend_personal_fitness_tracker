package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.CredentialsDoNotMatchException;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.EmailAlreadyRegisteredException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.UserNotFoundException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.PasswordMatcherService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.UserRepository;
import io.jsonwebtoken.Jwts;

import java.security.PrivateKey;
import java.time.Instant;
import java.util.Date;

public class UserServiceProvider implements UserService {
    private final long expirationInSeconds;
    private final PrivateKey privateKey;
    private final PasswordMatcherService passwordMatcherService;
    private final UserRepository userRepository;

    public UserServiceProvider(long expirationInSeconds, PrivateKey privateKey, PasswordMatcherService passwordMatcherService, UserRepository userRepository) {
        this.expirationInSeconds = expirationInSeconds;
        this.privateKey = privateKey;
        this.passwordMatcherService = passwordMatcherService;
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(User user) {
        boolean userIsFound = userRepository.existsByEmail(user.getEmail());

        if (userIsFound) {
            throw new EmailAlreadyRegisteredException("The given email is already associated with an user");
        }

        userRepository.save(user);
    }

    @Override
    public String signIn(User user) {
        User storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser == null) {
            throw new UserNotFoundException("The given user doesn't exist in the system");
        }

        String rawPassword = user.getPassword();
        String encodedPassword = userRepository.getEncodedPasswordByEmail(user.getEmail());

        boolean rawIsEqualToEncoded = passwordMatcherService.matches(rawPassword, encodedPassword);

        if (!rawIsEqualToEncoded) {
            throw new CredentialsDoNotMatchException("The given credentials do not match with any existing user");
        }

        return Jwts.builder()
                .subject(storedUser.getEmail())
                .claim("user", storedUser)
                .issuedAt(Date.from(
                        Instant.now()
                ))
                .expiration(Date.from(
                        Instant.now().plusSeconds(expirationInSeconds)
                ))
                .signWith(privateKey)
                .compact();
    }
}