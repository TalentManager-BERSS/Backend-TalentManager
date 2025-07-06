package com.berss.platform.iam.domain.model.commands;

import java.util.regex.Pattern;

/**
 * Command for registering a user together with a manager and a company.
 */
public record RegisterUserWithManagerCommand(
        String username,
        String password,
        String managerFirstname,
        String managerLastname,
        String companyName,
        String companyEmail,
        String companyDescription
) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public RegisterUserWithManagerCommand {
        // Username validations
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("username cannot be null or empty");
        }
        if (username.length() < 3 || username.length() > 50) {
            throw new IllegalArgumentException("username must be between 3 and 50 characters");
        }

        // Password validations
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("password must be at least 8 characters long");
        }

        // Manager firstname
        if (managerFirstname == null || managerFirstname.trim().isEmpty()) {
            throw new IllegalArgumentException("manager firstname cannot be null or empty");
        }
        if (managerFirstname.length() < 3 || managerFirstname.length() > 50) {
            throw new IllegalArgumentException("manager firstname must be between 3 and 50 characters");
        }

        // Manager lastname
        if (managerLastname == null || managerLastname.trim().isEmpty()) {
            throw new IllegalArgumentException("manager lastname cannot be null or empty");
        }
        if (managerLastname.length() < 3 || managerLastname.length() > 50) {
            throw new IllegalArgumentException("manager lastname must be between 3 and 50 characters");
        }

        // Company name
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new IllegalArgumentException("company name cannot be null or empty");
        }

        // Company email
        if (companyEmail == null || companyEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("company email cannot be null or empty");
        }
        if (!EMAIL_PATTERN.matcher(companyEmail).matches()) {
            throw new IllegalArgumentException("company email must be a valid email address");
        }

        // Company description
        if (companyDescription == null) {
            throw new IllegalArgumentException("company description cannot be null");
        }
        if (companyDescription.length() > 255) {
            throw new IllegalArgumentException("company description must be less than 256 characters");
        }
    }
}
