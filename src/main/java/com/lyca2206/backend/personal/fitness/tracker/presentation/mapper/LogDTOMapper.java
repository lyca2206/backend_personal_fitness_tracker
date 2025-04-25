package com.lyca2206.backend.personal.fitness.tracker.presentation.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.*;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.WorkoutService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.LogDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.function.Supplier;

@Mapper(componentModel = "spring", uses = { WorkoutService.class })
public interface LogDTOMapper {
    @Mapping(target = "workout", source = "workoutName")
    @Mapping(target = "exerciseLogs", expression = "java(listSupplier.get())")
    @Mapping(target = "user", expression = "java(user)")
    Log LogDTOToLog(LogDTO logDTO, @Context Supplier<List<ExerciseLog>> listSupplier, @Context User user);

    @AfterMapping
    default void fillExerciseLogs(LogDTO logDTO, @MappingTarget Log log) {
        List<WorkoutExercise> gatheredExercises = log.getWorkout().workoutExercises();
        List<Float> minutesPerEachExercise = logDTO.exerciseLogs();
        List<ExerciseLog> exerciseLogs = log.getExerciseLogs();

        for (int i = 0; i < gatheredExercises.size(); i++) {
            WorkoutExercise workoutExercise = gatheredExercises.get(i);
            float minutes = minutesPerEachExercise.get(i);

            exerciseLogs.add(new ExerciseLog(workoutExercise, minutes));
        }
    }
}