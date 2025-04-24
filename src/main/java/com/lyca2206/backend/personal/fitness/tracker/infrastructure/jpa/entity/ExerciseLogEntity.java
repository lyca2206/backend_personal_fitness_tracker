package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "EXERCISE_LOG")
public class ExerciseLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;

    @Column(name = "MINUTES", nullable = false)
    private float minutes;

    @ManyToOne
    @JoinColumn(name = "WORKOUT_EXERCISE", referencedColumnName = "ID", nullable = false)
    private WorkoutExerciseEntity workoutExercise;

    @ManyToOne
    @JoinColumn(name = "STORED_LOG", referencedColumnName = "ID", nullable = false)
    private LogEntity log;
}