package com.berss.platform.reports.domain.model.commands;

import java.time.LocalDate;

public record CreateReportCommand(
    String title,
    String content,
    Long companyId,
    LocalDate createdAt
) {

    public CreateReportCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content cannot be null or blank");
        }

        if (createdAt == null || createdAt.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("createdAt cannot be null or in the future");
        }

        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("companyId cannot be null or less than 1");
        }
    }
}
