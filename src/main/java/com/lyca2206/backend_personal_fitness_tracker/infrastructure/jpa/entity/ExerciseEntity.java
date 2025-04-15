package com.lyca2206.backend_personal_fitness_tracker.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Table(name = "EXERCISE")
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "MEASURE_UNIT", nullable = false)
    private String measureUnit;

    @Column(name = "CALORIES_PER_UNIT", nullable = false)
    private float caloriesPerUnit;
}