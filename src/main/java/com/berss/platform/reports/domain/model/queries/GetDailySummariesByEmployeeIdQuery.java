package com.berss.platform.reports.domain.model.queries;
import com.berss.platform.reports.domain.model.valueobjects.EmployeeId;

import com.berss.platform.reports.domain.model.valueobjects.EmployeeId;

public record GetDailySummariesByEmployeeIdQuery(EmployeeId employeeId) {
    public GetDailySummariesByEmployeeIdQuery {
        if (employeeId == null)
            throw new IllegalArgumentException("Employee ID must be positive and not null");
    }
}
