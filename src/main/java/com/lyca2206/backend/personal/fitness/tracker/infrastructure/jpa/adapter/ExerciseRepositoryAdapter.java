package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.ExerciseRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.ExerciseEntity;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper.ExerciseEntityMapper;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.ExerciseRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ExerciseRepositoryAdapter implements ExerciseRepository {
    private final ExerciseRepositoryJPA exerciseRepositoryJPA;
    private final ExerciseEntityMapper exerciseEntityMapper;

    @Override
    public List<Exercise> findAll() {
        return exerciseRepositoryJPA.findAll().stream()
                .map(exerciseEntityMapper::exerciseEntityToExercise)
                .toList();
    }

    @Override
    public void save(Exercise exercise) {
        ExerciseEntity exerciseEntity = exerciseEntityMapper.exerciseToExerciseEntity(exercise);
        exerciseRepositoryJPA.save(exerciseEntity);
    }

    @Override
    public Exercise findByName(String name) {
        ExerciseEntity exerciseEntity = exerciseRepositoryJPA.findByName(name);
        return exerciseEntityMapper.exerciseEntityToExercise(exerciseEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return exerciseRepositoryJPA.existsByName(name);
    }
}