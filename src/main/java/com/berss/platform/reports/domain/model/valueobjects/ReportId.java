package com.berss.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ReportId(Long reportId) {
    public ReportId {
        if (reportId == null || reportId < 1) {
            throw new IllegalArgumentException("Report id cannot be null or less than 1");
        }
    }

    public Long getValue() {
        return reportId;
    }
}