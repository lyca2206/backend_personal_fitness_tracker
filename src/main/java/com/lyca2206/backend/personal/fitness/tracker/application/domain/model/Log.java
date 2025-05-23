package com.lyca2206.backend.personal.fitness.tracker.application.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Log {
    private final Workout workout;
    private final List<ExerciseLog> exerciseLogs;
    private final User user;
    private final LocalDateTime time;

    public Log(Workout workout, List<ExerciseLog> exerciseLogs, User user) {
        validateWorkout(workout);
        validateExerciseLogs(exerciseLogs);
        validateUser(user);

        this.workout = workout;
        this.exerciseLogs = exerciseLogs;
        this.user = user;
        this.time = LocalDateTime.now();
    }

    private void validateWorkout(Workout workout) {
        if (workout == null) {
            throw new IllegalArgumentException("The given workout must be a non-null value");
        }
    }

    private void validateExerciseLogs(List<ExerciseLog> exerciseLogs) {
        if (exerciseLogs == null) {
            throw new IllegalArgumentException("The given list of exercise logs must be a non-null value");
        }
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("The given user must be a non-null value");
        }
    }

    public Workout getWorkout() {
        return workout;
    }

    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogs;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getSummary() {
        return "Workout: " + workout.name() + "\n" + "  Date: " + time.format(DateTimeFormatter.ISO_DATE);
    }

    public String getAllInformation() {
        StringBuilder builder = new StringBuilder();

        builder
                .append("Workout Details for ")
                .append(workout.name())
                .append(" on ")
                .append(time.format(DateTimeFormatter.ISO_DATE))
                .append(":")
                .append("\n\n");

        exerciseLogs.forEach(exerciseLog -> builder
                .append(exerciseLog.workoutExercise().exercise().name())
                .append(": ")
                .append(exerciseLog.minutes())
                .append(" minutes")
                .append("\n"));

        builder
                .append("\nTotal time: ").append(getTotalTime())
                .append("\nCalories: ").append(workout.getCalories());

        return builder.toString();
    }

    public float getTotalTime() {
        float totalTime = 0.0f;

        for (ExerciseLog exerciseLog : exerciseLogs) {
            totalTime += exerciseLog.minutes();
        }

        return totalTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "workout=" + workout +
                ", exerciseLogs=" + exerciseLogs +
                ", user=" + user +
                ", time=" + time +
                '}';
    }
}