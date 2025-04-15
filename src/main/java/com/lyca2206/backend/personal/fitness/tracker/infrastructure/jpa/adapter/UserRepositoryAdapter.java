package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.spi.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserRepositoryAdapter implements UserRepository {
    @Override
    public void save(User user) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public User findByEmail(String email) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean existsByEmail(String email) {
        throw new RuntimeException("Not yet implemented");
    }
}