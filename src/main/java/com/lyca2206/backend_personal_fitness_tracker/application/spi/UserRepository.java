package com.lyca2206.backend_personal_fitness_tracker.application.spi;

import com.lyca2206.backend_personal_fitness_tracker.application.domain.model.User;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
}