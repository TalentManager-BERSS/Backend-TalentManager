package com.berss.platform.employees.domain.model.queries;

public record GetEmployeesByIdQuery(Long employeeId) {
    public GetEmployeesByIdQuery{
        if (employeeId == null || employeeId <= 0) throw new IllegalArgumentException("Employee id is required.");

    }
}
