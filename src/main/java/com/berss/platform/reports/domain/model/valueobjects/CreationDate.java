package com.berss.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Value object representing the creation date of a report.
 * @summary
 * Ensures that the date is valid and not set in the future.
 * @param date The creation date of the report.
 * @since 1.0
 */
@Embeddable
public record CreationDate(LocalDate date) {
    public CreationDate {
        if (date == null) {
            throw new IllegalArgumentException("Creation date cannot be null");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Creation date cannot be in the future");
        }
    }

    public LocalDate getValue() {
        return date;
    }

    public Integer getMonth() {
        return date.getMonthValue();
    }

    public Integer getYear() {
        return date.getYear();
    }
}