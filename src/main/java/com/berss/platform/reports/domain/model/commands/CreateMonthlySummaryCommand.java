package com.berss.platform.reports.domain.model.commands;

public record CreateMonthlySummaryCommand(
        Long employeeId,
        Long companyId,
        Integer month,
        Integer year,
        Integer totalHours,
        Integer completedHours,
        Double inputAmount,
        Integer score
) {

    public CreateMonthlySummaryCommand {
        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("employee id cannot be null or less than 1");
        }

        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("company id cannot be null or less than 1");
        }

        if (month == null || month <= 0 || month >= 12) {
            throw new IllegalArgumentException("month cannot be null, less than 1 or greater than 12");
        }

        if (year == null || year <= 2000 || year >= 2100) {
            throw new IllegalArgumentException("year cannot be null, less than 2000 or greater than 2100");
        }

        if (totalHours == null || totalHours < 0) {
            throw new IllegalArgumentException("totalHours cannot be null or less than 1");
        }

        if (completedHours == null || completedHours < 0) {
            throw new IllegalArgumentException("completedHours cannot be null or less than 1");
        }

        if (inputAmount == null || inputAmount < 0) {
            throw new IllegalArgumentException("inputAmount cannot be null or less than 0");
        }

        if (score == null || score < 0 || score > 10) {
            throw new IllegalArgumentException("score cannot be null, less than 0 or greater than 10");
        }
    }
}