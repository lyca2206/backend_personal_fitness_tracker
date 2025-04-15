package com.lyca2206.backend.personal.fitness.tracker.application.domain.model;

public record ExerciseLog(WorkoutExercise workoutExercise, float minutes) {
    public ExerciseLog {
        validateWorkoutExercise(workoutExercise);
        validateMinutes(minutes);
    }

    private void validateWorkoutExercise(WorkoutExercise workoutExercise) {
        if (workoutExercise == null) {
            throw new IllegalArgumentException("The workout exercise needs to be a non null value");
        }
    }

    private void validateMinutes(float minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("The minute amount needs to be a non-negative number");
        }
    }

    @Override
    public String toString() {
        return "ExerciseLog{" +
                "workoutExercise=" + workoutExercise +
                ", minutes=" + minutes +
                '}';
    }
}