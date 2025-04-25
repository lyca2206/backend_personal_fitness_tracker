package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.ExerciseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseEntityMapper {
    Exercise ExerciseEntityToExercise(ExerciseEntity exerciseEntity);
}