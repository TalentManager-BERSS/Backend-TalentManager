package com.berss.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Score(int value) {
    public Score {
        if (value < 0 || value > 10) {
            throw new IllegalArgumentException("Score must be between 0 and 10");
        }
    }

    public int getValue() {
        return value;
    }
}