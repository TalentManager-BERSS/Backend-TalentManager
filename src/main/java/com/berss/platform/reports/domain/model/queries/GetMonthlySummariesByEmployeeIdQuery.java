package com.berss.platform.reports.domain.model.queries;

import com.berss.platform.reports.domain.model.valueobjects.EmployeeId;

public record GetMonthlySummariesByEmployeeIdQuery(EmployeeId employeeId) {
    public GetMonthlySummariesByEmployeeIdQuery {
        if (employeeId == null)
            throw new IllegalArgumentException("Employee ID must be positive and not null");
    }
}
