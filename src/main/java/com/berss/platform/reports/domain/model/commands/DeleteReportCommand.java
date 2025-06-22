package com.berss.platform.reports.domain.model.commands;

/**
 * Command to delete a report
 * @param reportId the report id.
 *                 Cannot be null or less than 1
 */

public record DeleteReportCommand(Long reportId) {
    /**
     * Constructor
     * @param reportId the report id.
     *                 Cannot be null or less than 1
     * @throws IllegalArgumentException if reportId is null or less than 1
     */
    public DeleteReportCommand {
        if (reportId == null || reportId <= 0) {
            throw new IllegalArgumentException("reportId cannot be null or less than 1");
        }
    }
}