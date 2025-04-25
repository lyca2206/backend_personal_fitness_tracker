package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.WorkoutExercise;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.WorkoutExerciseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ExerciseEntityMapper.class })
public interface WorkoutExerciseEntityMapper {
    WorkoutExercise workoutExerciseEntityToWorkoutExercise(WorkoutExerciseEntity workoutExerciseEntity);
    WorkoutExerciseEntity workoutExerciseToWorkoutExerciseEntity(WorkoutExercise workoutExercise);
}