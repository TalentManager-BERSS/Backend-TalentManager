package com.berss.platform.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public record ReceivedAt(LocalDateTime value) {
    public ReceivedAt {
        if (value == null)
            throw new IllegalArgumentException("ReceivedAt cannot be null");
        if (value.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("ReceivedAt cannot be in the future");
    }
}
