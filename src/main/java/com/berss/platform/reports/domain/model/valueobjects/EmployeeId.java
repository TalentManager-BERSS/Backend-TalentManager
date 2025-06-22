package com.berss.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the employee id.
 * @summary
 * This value object is used to represent the employee id.
 * It throws an IllegalArgumentException if the employee id is null or less than 1.
 * @param employeeId The employee id. It cannot be null or less than 1.
 * @see IllegalArgumentException
 * @since 1.0
 */

@Embeddable
public record EmployeeId(Long employeeId) {
    public EmployeeId {
        if (employeeId == null || employeeId < 1) {
            throw new IllegalArgumentException("Employee id cannot be null or less than 1");
        }
    }

    public Long getValue() {
        return employeeId;
    }
}