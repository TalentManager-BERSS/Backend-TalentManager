package com.berss.platform.reports.domain.model.commands;

public record CreateReportCommand(
        String title,
        String content,
        Long companyId,
        Long monthlySummaryId
) {
    public CreateReportCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content cannot be null or blank");
        }

        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("companyId cannot be null or less than 1");
        }

        if (monthlySummaryId == null || monthlySummaryId <= 0) {
            throw new IllegalArgumentException("monthlySummaryId cannot be null or less than 1");
        }
    }
}
