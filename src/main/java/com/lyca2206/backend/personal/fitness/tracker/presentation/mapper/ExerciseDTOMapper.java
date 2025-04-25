package com.lyca2206.backend.personal.fitness.tracker.presentation.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.ExerciseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseDTOMapper {
    Exercise ExerciseDTOToExercise(ExerciseDTO exerciseDTO);
}