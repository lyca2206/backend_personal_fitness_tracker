package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "WORKOUT_EXERCISE")
public class WorkoutExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;

    @Column(name = "SETS", nullable = false)
    private int sets;

    @Column(name = "UNITS", nullable = false)
    private float units;

    @ManyToOne
    @JoinColumn(name = "EXERCISE", referencedColumnName = "ID", nullable = false)
    private ExerciseEntity exercise;

    @ManyToOne
    @JoinColumn(name = "WORKOUT", referencedColumnName = "ID", nullable = false)
    private WorkoutEntity workout;

    @OneToMany(mappedBy = "workoutExercise")
    private List<ExerciseLogEntity> exerciseLogs;
}