package com.lyca2206.backend.personal.fitness.tracker.presentation.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.*;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.WorkoutService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.ExerciseLogDTO;
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
    default void afterMapping(
            LogDTO logDTO,
            @MappingTarget Log log
    ) {
        List<ExerciseLogDTO> exerciseLogDTOs = logDTO.exerciseLogs();
        List<WorkoutExercise> workoutExercises = log.getWorkout().workoutExercises();
        List<ExerciseLog> exerciseLogs = log.getExerciseLogs();

        for (int i = 0; i < workoutExercises.size(); i++) {
            exerciseLogs.add(new ExerciseLog(
                    workoutExercises.get(i),
                    exerciseLogDTOs.get(i).minutes()
            ));
        }
    }
}