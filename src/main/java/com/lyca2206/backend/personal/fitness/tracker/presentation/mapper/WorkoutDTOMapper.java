package com.lyca2206.backend.personal.fitness.tracker.presentation.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.WorkoutDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { WorkoutExerciseDTOMapper.class })
public interface WorkoutDTOMapper {
    Workout WorkoutDTOToWorkout(WorkoutDTO workoutDTO);
}