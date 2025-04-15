package com.lyca2206.backend_personal_fitness_tracker.presentation.controller;

import com.lyca2206.backend_personal_fitness_tracker.application.api.ExerciseService;
import com.lyca2206.backend_personal_fitness_tracker.presentation.dto.CreateExerciseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;

@AllArgsConstructor
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping
    public void createExercise(@RequestBody CreateExerciseDTO createExerciseDTO) throws InstanceAlreadyExistsException {
        exerciseService.createExercise(
                createExerciseDTO.name(),
                createExerciseDTO.measureUnit(),
                createExerciseDTO.caloriesPerUnit()
        );
    }
}