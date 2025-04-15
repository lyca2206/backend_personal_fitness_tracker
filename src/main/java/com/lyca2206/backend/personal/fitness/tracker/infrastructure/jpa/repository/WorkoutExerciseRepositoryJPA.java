package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository;

import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.WorkoutExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkoutExerciseRepositoryJPA extends JpaRepository<WorkoutExerciseEntity, UUID> {

}