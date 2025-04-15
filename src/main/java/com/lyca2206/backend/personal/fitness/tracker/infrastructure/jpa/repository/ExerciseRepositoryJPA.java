package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository;

import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepositoryJPA extends JpaRepository<ExerciseEntity, Long> {
    boolean existsByName(String name);
}