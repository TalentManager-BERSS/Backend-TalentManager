package com.berss.platform.employees.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Value object representing an employee's entry date.
 * @summary
 * This value object ensures that the entry date is valid (i.e., not null and not in the future).
 * It is used in the Employee aggregate.
 * @param date The entry date. Must not be null or a future date.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record EntryDate(LocalDate date) {
    public EntryDate {
        if (date == null) {
            throw new IllegalArgumentException("Entry date cannot be null");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Entry date cannot be in the future");
        }
    }

    public LocalDate getValue() {
        return date;
    }
}

