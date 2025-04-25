package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.WorkoutRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.WorkoutEntity;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper.WorkoutEntityMapper;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.WorkoutRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class WorkoutRepositoryAdapter implements WorkoutRepository {
    private final WorkoutRepositoryJPA workoutRepositoryJPA;
    private final WorkoutEntityMapper workoutEntityMapper;

    @Override
    public List<Workout> findAll() {
        return workoutRepositoryJPA.findAll().stream()
                .map(workoutEntityMapper::workoutEntityToWorkout)
                .toList();
    }

    @Override
    public void save(Workout workout) {
        WorkoutEntity workoutEntity = new WorkoutEntity();

        workoutEntity.setName(workout.name());
        workoutEntity.setDescription(workout.description());
        workoutEntity.setWorkoutExercises(List.of());
        workoutEntity.setNotes(workout.notes());

        workoutRepositoryJPA.save(workoutEntity);
    }

    @Override
    public Workout findByName(String name) {
        WorkoutEntity workoutEntity = workoutRepositoryJPA.findByName(name);
        return workoutEntityMapper.workoutEntityToWorkout(workoutEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return workoutRepositoryJPA.existsByName(name);
    }
}