package com.lyca2206.backend.personal.fitness.tracker.application.domain.model;

import java.util.regex.Pattern;

public class User {
    private String email;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;

    public User(String email, String password, String role, String firstName, String lastName) {
        setEmail(email);
        setPassword(password);
        setRole(role);
        setFirstName(firstName);
        setLastName(lastName);
    }

    private void setEmail(String email) {
        validateEmail(email);
        this.email = email;
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

    private void setPassword(String password) {
        validatePassword(password);
        this.password = password;
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

    private void setRole(String role) {
        if (role == null) {
            this.role = Role.REGULAR;
        } else {
            this.role = Role.valueOf(role);
        }
    }

    private void setFirstName(String firstName) {
        validateName(firstName);
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        validateName(lastName);
        this.lastName = lastName;
    }

    private void validateName(String name) {
        if (name == null) {
            return;
        }

        if (name.length() < 3) {
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