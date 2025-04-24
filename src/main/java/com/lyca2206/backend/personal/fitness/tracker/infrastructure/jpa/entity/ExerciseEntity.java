package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "EXERCISE")
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "MEASURE_UNIT", nullable = false)
    private String measureUnit;

    @Column(name = "CALORIES_PER_UNIT", nullable = false)
    private float caloriesPerUnit;

    @OneToMany(mappedBy = "exercise")
    private List<WorkoutExerciseEntity> workoutExercises;
}