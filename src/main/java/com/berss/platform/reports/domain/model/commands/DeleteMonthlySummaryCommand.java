package com.berss.platform.reports.domain.model.commands;

/**
 * Command to delete a monthly summary
 * @param monthlySummaryId the monthly summary id.
 *                 Cannot be null or less than 1
 */

public record DeleteMonthlySummaryCommand(Long monthlySummaryId) {
    /**
     * Constructor
     * @param monthlySummaryId the report id.
     *                 Cannot be null or less than 1
     * @throws IllegalArgumentException if monthlySummaryId is null or less than 1
     */
    public DeleteMonthlySummaryCommand {
        if (monthlySummaryId == null || monthlySummaryId <= 0) {
            throw new IllegalArgumentException("monthlySummaryId cannot be null or less than 1");
        }
    }
}