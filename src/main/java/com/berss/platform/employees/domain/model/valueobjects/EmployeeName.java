package com.berss.platform.employees.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing an employee's name.
 * @summary
 * This value object encapsulates an employee's first and last name. It is used in the Employee aggregate.
 * It throws an IllegalArgumentException if either name is null or blank.
 * @param firstName The employee's first name.
 * @param lastName The employee's last name.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record EmployeeName(String firstName, String lastName) {
    public EmployeeName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}