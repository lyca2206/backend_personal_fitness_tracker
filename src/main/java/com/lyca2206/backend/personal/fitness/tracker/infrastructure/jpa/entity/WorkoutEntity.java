package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "WORKOUT")
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NOTES")
    private String notes;

    @OneToMany(mappedBy = "workout")
    private List<WorkoutExerciseEntity> workoutExercises;

    @OneToMany(mappedBy = "workout")
    private List<LogEntity> logs;
}