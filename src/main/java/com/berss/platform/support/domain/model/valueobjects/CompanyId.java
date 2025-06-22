package com.berss.platform.support.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * Value object representing the company id.
 */
@Embeddable
public record CompanyId(@Column(name = "company_id") Long value) implements Serializable {
    public CompanyId {
        if (value == null || value < 1) {
            throw new IllegalArgumentException("Company id cannot be null or less than 1");
        }
    }

    public Long asLong() {
        return value;
    }
}
