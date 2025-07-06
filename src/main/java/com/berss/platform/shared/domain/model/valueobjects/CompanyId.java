package com.berss.platform.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the company id.
 * @summary
 * This value object is used to represent the company id.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyId)) return false;
        CompanyId that = (CompanyId) o;
        return companyId.equals(that.companyId);
    }

    @Override
    public int hashCode() {
        return companyId.hashCode();
    }
}
