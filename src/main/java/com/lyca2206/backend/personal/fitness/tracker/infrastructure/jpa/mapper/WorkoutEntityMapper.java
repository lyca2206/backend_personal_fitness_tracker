package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.WorkoutEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { WorkoutExerciseEntityMapper.class })
public interface WorkoutEntityMapper {
    Workout workoutEntityToWorkout(WorkoutEntity workoutEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "logs", ignore = true)
    WorkoutEntity workoutToWorkoutEntity(Workout workout);
}