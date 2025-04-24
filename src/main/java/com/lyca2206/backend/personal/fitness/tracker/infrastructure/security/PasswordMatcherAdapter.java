package com.lyca2206.backend.personal.fitness.tracker.infrastructure.security;

import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.PasswordMatcherService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PasswordMatcherAdapter implements PasswordMatcherService {
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}