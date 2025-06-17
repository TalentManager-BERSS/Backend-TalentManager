package com.berss.platform.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record SupportMessageId(Long value) {
    public SupportMessageId {
        if (value == null || value < 1)
            throw new IllegalArgumentException("SupportMessageId must be a positive number");
    }
}
