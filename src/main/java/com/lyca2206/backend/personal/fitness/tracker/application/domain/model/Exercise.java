package com.lyca2206.backend.personal.fitness.tracker.application.domain.model;

public record Exercise(String name, String measureUnit, float caloriesPerUnit) {
    public Exercise {
        validateName(name);
        validateMeasureUnit(measureUnit);
        validateCaloriesPerUnit(caloriesPerUnit);
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The exercise's name needs to be non-null or non-empty");
        }
    }

    private void validateMeasureUnit(String measureUnit) {
        if (measureUnit == null || measureUnit.isEmpty()) {
            throw new IllegalArgumentException("The unit of measure needs to be non-null or non-empty");
        }
    }

    private void validateCaloriesPerUnit(float caloriesPerUnit) {
        if (caloriesPerUnit <= 0) {
            throw new IllegalArgumentException("The calories per unit needs to be a positive value");
        }
    }
}