package com.berss.platform.reports.interfaces.rest.resources;

public record DailySummaryResource(
        Long id,
        Long employeeId,
        Long companyId,
        Integer day,
        Integer month,
        Integer year,
        Integer entryTime,
        Integer exitTime,
        Double inputAmount,
        Integer score
) {}