package com.lyca2206.backend.personal.fitness.tracker.presentation.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignInDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SignInDTOMapper {
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    User SignInDTOToUser(SignInDTO signInDTO);
}