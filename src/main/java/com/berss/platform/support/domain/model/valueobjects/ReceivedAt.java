package com.berss.platform.support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Embeddable
public record ReceivedAt(LocalDateTime value) {
    public ReceivedAt {
        if (value == null)
            throw new IllegalArgumentException("ReceivedAt cannot be null");

        // Comparación en UTC para evitar errores de zona horaria
        var valueUtc = value.atOffset(ZoneOffset.UTC).toInstant();
        var nowUtc = LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC);

        if (valueUtc.isAfter(nowUtc))
            throw new IllegalArgumentException("ReceivedAt cannot be in the future");
    }
}
