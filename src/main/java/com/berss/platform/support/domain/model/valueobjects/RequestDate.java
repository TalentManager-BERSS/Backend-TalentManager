package com.berss.platform.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

/**
 * Value object representing the request date of a support message.
 * Cannot be null or in the future.
 */
@Embeddable
public record RequestDate(LocalDateTime value) {
    public RequestDate {
        if (value == null) {
            throw new IllegalArgumentException("Request date cannot be null");
        }
        if (value.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Request date cannot be in the future");
        }
    }
}