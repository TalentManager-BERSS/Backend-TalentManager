package com.berss.platform.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;

import java.time.ZoneOffset;

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

        // Convierte el valor recibido a UTC
        var valueUtc = value.atOffset(ZoneOffset.UTC).toInstant();
        var nowUtc = LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC);

        if (valueUtc.isAfter(nowUtc)) {
            throw new IllegalArgumentException("Request date cannot be in the future");
        }
    }
}
