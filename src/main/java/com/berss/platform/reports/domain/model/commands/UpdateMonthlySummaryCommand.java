package com.berss.platform.reports.domain.model.commands;

/**
 * Command to update a monthly report
 *
 * @param totalHours the monthly report total hours for an employee.
 *              Cannot be null or less than 0
 * @param completedHours the monthly report completed hours for an employee.
 *              Cannot be null or less than 0
 * @param score the monthly report score for an employee.
 *              Cannot be null, less than 1 or greater than 10
 * @param inputAmount the monthly report inputAmount for an employee.
 *              Cannot be null or negative
 */

public record UpdateMonthlySummaryCommand(Long monthlySummaryId, Integer totalHours, Integer completedHours, Integer score, Double inputAmount) {
    public UpdateMonthlySummaryCommand {
        if (totalHours == null || totalHours < 0) {
            throw new IllegalArgumentException("totalHours cannot be null or less than 1");
        }

        if (completedHours == null || completedHours < 0) {
            throw new IllegalArgumentException("completedHours cannot be null or less than 1");
        }

        if (score == null || score <= 0) {
            throw new IllegalArgumentException("score cannot be null, less than 0 or greater than 10");
        }

        if (inputAmount == null || inputAmount < 0) {
            throw new IllegalArgumentException("inputAmount cannot be null or negative");
        }
    }
}