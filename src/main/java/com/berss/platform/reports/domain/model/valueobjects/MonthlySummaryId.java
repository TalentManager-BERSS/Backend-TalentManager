package com.berss.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record MonthlySummaryId(Long monthlySummaryId) {
    public MonthlySummaryId {
        if (monthlySummaryId == null || monthlySummaryId < 1) {
            throw new IllegalArgumentException("Monthly Summary id cannot be null or less than 1");
        }
    }

    public Long getValue() {
        return monthlySummaryId;
    }
}