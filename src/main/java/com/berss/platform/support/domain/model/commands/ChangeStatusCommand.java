package com.berss.platform.support.domain.model.commands;


public record ChangeStatusCommand(Long supportMessageId, String newStatus) {
    public ChangeStatusCommand{
        if (supportMessageId == null || supportMessageId <= 0)
            throw new IllegalArgumentException("SupportMessageId cannot be null or <= 0");
        if (newStatus == null || newStatus.isBlank())
            throw new IllegalArgumentException("Status name cannot be null or blank");
    }
}
