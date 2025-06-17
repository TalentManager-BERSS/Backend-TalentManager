package com.berss.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record YearMonthPeriod(int year, int month) {
    public YearMonthPeriod {
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        if (year < 2000 || year > 2100)
            throw new IllegalArgumentException("Year must be between 2000 and 2100.");
    }

    public String asString() {
        return "%04d-%02d".formatted(year, month);
    }
}