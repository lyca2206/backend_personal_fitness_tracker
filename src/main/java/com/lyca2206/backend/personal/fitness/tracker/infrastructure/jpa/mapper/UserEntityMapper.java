package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserEntityMapper {
    protected PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Mapping(target = "password", ignore = true)
    public abstract User userEntityToUser(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "logs", ignore = true)
    @Mapping(target = "password", source = "password", qualifiedByName = "encode")
    public abstract UserEntity userToUserEntity(User user);

    @Named("encode")
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}