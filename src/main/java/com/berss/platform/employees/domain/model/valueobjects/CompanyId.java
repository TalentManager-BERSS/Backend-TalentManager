package com.berss.platform.employees.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the company id.
 * @summary
 * This value object is used to represent the company id. It is an embeddable object that is used to represent the company id in the employee aggregate.
 * It throws an IllegalArgumentException if the company id is null or less than 1.
 * @param companyId The company id. It cannot be null or less than 1.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record CompanyId(Long companyId) {
    public CompanyId {
        if (companyId == null || companyId < 1) {
            throw new IllegalArgumentException("Company id cannot be null or less than 1");
        }
    }

    public Long getValue() {
        return companyId;
    }
}