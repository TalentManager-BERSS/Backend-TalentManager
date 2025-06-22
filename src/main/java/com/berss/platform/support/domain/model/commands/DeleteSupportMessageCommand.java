package com.berss.platform.support.domain.model.commands;


public record DeleteSupportMessageCommand(Long supportMessageId) {
    public DeleteSupportMessageCommand {
        if (supportMessageId == null || supportMessageId <= 0) {
            throw new IllegalArgumentException("supportMessageId cannot be null or less than 1");
        }
    }
}
