package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "STORED_LOG")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;

    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "WORKOUT", referencedColumnName = "ID", nullable = false)
    private WorkoutEntity workout;

    @ManyToOne
    @JoinColumn(name = "STORED_USER", referencedColumnName = "ID", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "log")
    private List<ExerciseLogEntity> exerciseLogs;
}