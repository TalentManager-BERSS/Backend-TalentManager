package com.berss.platform.iam.domain.model.commands;

/**
 * Command for creating a new User in the system.
 */
public record CreateUserCommand(
        String username,
        String rawPassword,
        Long managerId
) {

    public CreateUserCommand {
        // Validate username
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("username cannot be null or empty");
        }
        if (username.length() < 3 || username.length() > 50) {
            throw new IllegalArgumentException("username must be between 3 and 50 characters");
        }

        // Validate rawPassword
        if (rawPassword == null || rawPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (rawPassword.length() < 8) {
            throw new IllegalArgumentException("password must be at least 8 characters long");
        }

        // Validate managerId
        if (managerId == null || managerId <= 0) {
            throw new IllegalArgumentException("managerId must be greater than 0");
        }
    }
}
