package com.berss.platform.reports.domain.model.commands;

/**
 * Command to update a report
 *
 * @param title the report title.
 *              Cannot be null or blank
 * @param content the report description.
 *                    Cannot be null or blank
 */

public record UpdateReportCommand(Long reportId, String title, String content) {
    public UpdateReportCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content cannot be null or blank");
        }
    }
}
