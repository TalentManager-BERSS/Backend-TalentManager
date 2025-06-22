package com.berss.platform.support.domain.model.commands;

import java.time.LocalDateTime;

public record CreateSupportMessageCommand(String content, Long companyId, LocalDateTime requestDate, LocalDateTime receivedAt) {
    public CreateSupportMessageCommand {
        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("Company ID cannot be null or blank");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content cannot be null or blank");
        }

    }
}
