package com.berss.platform.reports.domain.model.commands;

/**
 * Command to delete a monthly summary
 * @param dailySummaryId the monthly summary id.
 *                 Cannot be null or less than 1
 */

public record DeleteDailySummaryCommand(Long dailySummaryId) {
    /**
     * Constructor
     * @param dailySummaryId the report id.
     *                 Cannot be null or less than 1
     * @throws IllegalArgumentException if dailySummaryId is null or less than 1
     */
    public DeleteDailySummaryCommand {
        if (dailySummaryId == null || dailySummaryId <= 0) {
            throw new IllegalArgumentException("dailySummaryId cannot be null or less than 1");
        }
    }
}