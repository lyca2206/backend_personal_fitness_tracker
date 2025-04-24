package com.lyca2206.backend.personal.fitness.tracker.application.port.spi;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
    String getEncodedPasswordByEmail(String email);
    boolean existsByEmail(String email);
}