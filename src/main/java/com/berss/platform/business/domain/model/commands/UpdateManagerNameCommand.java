package com.berss.platform.business.domain.model.commands;

/**
 * Command for updating the first and last name of a Manager.
 */
public record UpdateManagerNameCommand(
        Long managerId,
        String firstname,
        String lastname
) {

    public UpdateManagerNameCommand {
        // Validate managerId
        if (managerId == null || managerId <= 0) {
            throw new IllegalArgumentException("managerId must be greater than 0");
        }

        // Validate firstname
        if (firstname == null || firstname.trim().isEmpty()) {
            throw new IllegalArgumentException("firstname cannot be null or empty");
        }
        if (firstname.length() < 3 || firstname.length() > 50) {
            throw new IllegalArgumentException("firstname must be between 3 and 50 characters");
        }

        // Validate lastname
        if (lastname == null || lastname.trim().isEmpty()) {
            throw new IllegalArgumentException("lastname cannot be null or empty");
        }
        if (lastname.length() < 3 || lastname.length() > 50) {
            throw new IllegalArgumentException("lastname must be between 3 and 50 characters");
        }
    }
}
