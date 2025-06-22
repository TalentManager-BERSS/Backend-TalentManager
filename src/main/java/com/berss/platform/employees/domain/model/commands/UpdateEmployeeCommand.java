package com.berss.platform.employees.domain.model.commands;

import java.time.LocalDate;

public record UpdateEmployeeCommand(Long employeeId, String firstName, String lastName, String occupation, LocalDate entryDate, String teamName) {
    public UpdateEmployeeCommand {
        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("courseId cannot be null or less than 1");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName cannot be null or blank");
        }
        if (occupation == null || occupation.isBlank()) {
            throw new IllegalArgumentException("occupation name cannot be null or blank");
        }
        if (entryDate == null) {
            throw new IllegalArgumentException("entryDate name cannot be null");
        }
        if (teamName == null || teamName.isBlank()) {
            throw new IllegalArgumentException("teamName name cannot be null or blank");
        }
    }
}
