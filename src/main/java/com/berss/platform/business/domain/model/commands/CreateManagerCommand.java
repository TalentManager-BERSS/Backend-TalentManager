package com.berss.platform.business.domain.model.commands;

/**
 * Command for creating a Manager and its associated Company.
 */
public record CreateManagerCommand(
        String firstname,
        String lastname,
        String companyName,
        String companyEmail,
        String companyDescription
) {

    public CreateManagerCommand {
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

        // Validate company name
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new IllegalArgumentException("company name cannot be null or empty");
        }

        // Validate company email format
        if (companyEmail == null || !companyEmail.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,}$")) {
            throw new IllegalArgumentException("company email must be a valid email address");
        }

        // Validate company description
        if (companyDescription == null) {
            throw new IllegalArgumentException("company description cannot be null");
        }
        if (companyDescription.length() > 255) {
            throw new IllegalArgumentException("company description must be less than 255 characters");
        }
    }
}
