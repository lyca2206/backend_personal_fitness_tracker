package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.ExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseEntityMapper {
    Exercise exerciseEntityToExercise(ExerciseEntity exerciseEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "workoutExercises", ignore = true)
    ExerciseEntity exerciseToExerciseEntity(Exercise exercise);
}