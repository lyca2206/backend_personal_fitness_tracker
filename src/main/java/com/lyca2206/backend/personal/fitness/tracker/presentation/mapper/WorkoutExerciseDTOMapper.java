package com.lyca2206.backend.personal.fitness.tracker.presentation.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.WorkoutExercise;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.WorkoutExerciseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ExerciseService.class })
public interface WorkoutExerciseDTOMapper {
    @Mapping(target = "exercise", source = "exerciseName")
    WorkoutExercise WorkoutExerciseDTOToWorkoutExercise(WorkoutExerciseDTO exerciseDTO);
}