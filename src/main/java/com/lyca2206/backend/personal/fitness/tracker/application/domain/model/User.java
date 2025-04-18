package com.lyca2206.backend.personal.fitness.tracker.application.domain.model;

import java.util.regex.Pattern;

public class User {
    private final String email;
    private final String password;
    private final Role role;
    private final String firstName;
    private final String lastName;

    public User(String email, String password) {
        validateEmail(email);
        validatePassword(password);

        this.email = email;
        this.password = password;
        this.role = null;
        this.firstName = null;
        this.lastName = null;
    }

    public User(String email, String password, String role, String firstName, String lastName) {
        validateEmail(email);
        validatePassword(password);
        validateRole(role);
        validateName(firstName);
        validateName(lastName);

        this.email = email;
        this.password = password;
        this.role = Role.valueOf(role);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String role, String firstName, String lastName) {
        validateEmail(email);
        validateRole(role);
        validateName(firstName);
        validateName(lastName);

        this.email = email;
        this.password = null;
        this.role = Role.valueOf(role);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private void validateEmail(String email) {
        Pattern regexPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

        boolean match = regexPattern
                .matcher(email)
                .matches();

        if (!match) {
            throw new IllegalArgumentException("The given email is invalid: it requires an @ and a domain (.com, .org, etc.)");
        }
    }

    private void validatePassword(String password) {
        if (password == null) {
            return;
        }

        Pattern regexPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

        boolean match = regexPattern
                .matcher(password)
                .matches();

        if (!match) {
            throw new IllegalArgumentException("The given password is invalid: it must contain 8 characters, 1 digit, 1 uppercase letter and 1 lowercase letter");
        }
    }

    private void validateRole(String role) {
        if (role == null) {
            throw new IllegalArgumentException("The given role must be a non-null value");
        }
    }

    private void validateName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Any of the names should be at least 3 characters long, and it has to be a non-null value");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}