package com.lyca2206.backend.personal.fitness.tracker.application.port.spi;

public interface PasswordMatcherService {
    boolean matches(String rawPassword, String encodedPassword);
}