package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.ExerciseRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.ExerciseEntity;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.ExerciseRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ExerciseRepositoryAdapter implements ExerciseRepository {
    private final ExerciseRepositoryJPA exerciseRepositoryJPA;

    @Override
    public void save(Exercise exercise) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();

        exerciseEntity.setName(exercise.name());
        exerciseEntity.setMeasureUnit(exercise.measureUnit());
        exerciseEntity.setCaloriesPerUnit(exercise.caloriesPerUnit());

        exerciseRepositoryJPA.save(exerciseEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return exerciseRepositoryJPA.existsByName(name);
    }
}