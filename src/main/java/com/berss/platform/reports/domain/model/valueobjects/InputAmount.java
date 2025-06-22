package com.berss.platform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record InputAmount(double value) {

    public InputAmount {
        if (value < 0) {
            throw new IllegalArgumentException("Input amount cannot be negative");
        }
    }

    public double getValue() {
        return value;
    }
}
