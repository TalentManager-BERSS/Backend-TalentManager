package com.berss.platform.employees.domain.model.commands;

public record DeleteEmployeeCommand(Long employeeId) {
    public DeleteEmployeeCommand {
        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("employeeId cannot be null or less than 1");
        }
    }
}
