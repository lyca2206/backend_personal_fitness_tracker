package com.lyca2206.backend.personal.fitness.tracker.presentation.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignUpDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SignUpDTOMapper {
    User SignUpDTOToUser(SignUpDTO signUpDTO);
}