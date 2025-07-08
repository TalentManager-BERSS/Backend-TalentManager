package com.berss.platform.reports.domain.model.commands;

/**
 * Command to update a daily summary
 *
 * @param entryTime the daily summary entry hour for an employee.
 *              Cannot be null or less than 0
 * @param exitTime the daily summary exit hour for an employee.
 *              Cannot be null or less than 0
 * @param score the daily summary score for an employee.
 *              Cannot be null, less than 1 or greater than 10
 * @param inputAmount the daily summary inputAmount for an employee.
 *              Cannot be null or negative
 */

public record UpdateDailySummaryCommand(Long dailySummaryId, Integer entryTime, Integer exitTime, Integer score, Double inputAmount) {
    public UpdateDailySummaryCommand {
        if (entryTime == null || entryTime < 0 || entryTime > 24) {
            throw new IllegalArgumentException("entryTime cannot be null, less than 0 or greater than 24");
        }

        if (exitTime == null || exitTime < 0 || exitTime > 24) {
            throw new IllegalArgumentException("exitTime cannot be null, less than 0 or greater than 24");
        }

        if (score == null || score <= 0) {
            throw new IllegalArgumentException("score cannot be null, less than 0 or greater than 10");
        }

        if (inputAmount == null || inputAmount < 0) {
            throw new IllegalArgumentException("inputAmount cannot be null or negative");
        }
    }
}