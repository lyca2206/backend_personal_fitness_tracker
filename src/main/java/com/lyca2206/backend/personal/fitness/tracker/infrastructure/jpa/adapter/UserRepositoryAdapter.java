package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.UserRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.UserEntity;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper.UserEntityMapper;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.UserRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserRepositoryAdapter implements UserRepository {
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void save(User user) {
        UserEntity userEntity = userEntityMapper.userToUserEntity(user);
        userRepositoryJPA.save(userEntity);
    }

    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = userRepositoryJPA.findByEmail(email);

        if (userEntity == null) {
            return null;
        }

        return userEntityMapper.userEntityToUser(userEntity);
    }

    @Override
    public String getEncodedPasswordByEmail(String email) {
        UserEntity userEntity = userRepositoryJPA.findByEmail(email);

        if (userEntity == null) {
            return null;
        }

        return userEntity.getPassword();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepositoryJPA.existsByEmail(email);
    }
}