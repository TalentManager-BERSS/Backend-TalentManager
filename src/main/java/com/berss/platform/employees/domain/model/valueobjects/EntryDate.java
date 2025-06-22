package com.berss.platform.employees.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public record EntryDate(LocalDate entryDate) {
    public EntryDate {
        if (entryDate == null) {
            throw new IllegalArgumentException("Entry date cannot be null");
        }
        if (entryDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Entry date cannot be in the future");
        }
    }
}

