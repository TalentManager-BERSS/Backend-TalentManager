package com.berss.platform.employees.domain.model.commands;

import java.time.LocalDate;

/**
 * Command for creating an Employee.
 */
public record CreateEmployeeCommand(
        String firstName,
        String lastName,
        String occupation,
        LocalDate entryDate,
        String teamName,
        Long companyId
) {

    public CreateEmployeeCommand {
        // Validate firstName
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        if (firstName.length() < 3 || firstName.length() > 50) {
            throw new IllegalArgumentException("firstName must be between 3 and 50 characters");
        }

        // Validate lastName
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        if (lastName.length() < 3 || lastName.length() > 50) {
            throw new IllegalArgumentException("lastName must be between 3 and 50 characters");
        }

        // Validate occupation
        if (occupation == null || occupation.trim().isEmpty()) {
            throw new IllegalArgumentException("occupation cannot be null or empty");
        }

        // Validate entryDate
        if (entryDate == null) {
            throw new IllegalArgumentException("entryDate cannot be null");
        }

        // Validate teamName
        if (teamName == null || teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("teamName cannot be null or empty");
        }
        if (teamName.length() < 3 || teamName.length() > 50) {
            throw new IllegalArgumentException("teamName must be between 3 and 50 characters");
        }

        // Validate companyId
        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("companyId must be greater than 0");
        }
    }
}
