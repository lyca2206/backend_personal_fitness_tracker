package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.WorkoutExercise;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.WorkoutExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ExerciseEntityMapper.class })
public interface WorkoutExerciseEntityMapper {
    WorkoutExercise workoutExerciseEntityToWorkoutExercise(WorkoutExerciseEntity workoutExerciseEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "workout", ignore = true)
    @Mapping(target = "exerciseLogs", ignore = true)
    WorkoutExerciseEntity workoutExerciseToWorkoutExerciseEntity(WorkoutExercise workoutExercise);
}