package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.ExerciseLog;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.ExerciseLogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { WorkoutExerciseEntityMapper.class })
public interface ExerciseLogEntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "log", ignore = true)
    ExerciseLogEntity ExerciseLogToExerciseLogEntity(ExerciseLog exerciseLog);
}