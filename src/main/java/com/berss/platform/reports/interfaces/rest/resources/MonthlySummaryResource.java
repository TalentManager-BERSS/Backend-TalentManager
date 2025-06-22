package com.berss.platform.reports.interfaces.rest.resources;
public record MonthlySummaryResource(
        Long id,
        Long employeeId,
        Long companyId,
        Integer month,
        Integer year,
        Integer totalHours,
        Integer completedHours,
        Double inputAmount,
        Integer score
) {}