package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.CreateExerciseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping
    public void createExercise(@RequestBody CreateExerciseDTO createExerciseDTO) {
        exerciseService.createExercise(
                createExerciseDTO.name(),
                createExerciseDTO.measureUnit(),
                createExerciseDTO.caloriesPerUnit()
        );
    }
}