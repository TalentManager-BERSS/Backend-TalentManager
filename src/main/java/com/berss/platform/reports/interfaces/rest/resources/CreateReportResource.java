package com.berss.platform.reports.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateReportResource(
        String title,
        String content,
        Long companyId,
        Long monthlySummaryId

)
{
    public CreateReportResource {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }
        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("Company ID cannot be null or less than 1");
        }
    }
}
