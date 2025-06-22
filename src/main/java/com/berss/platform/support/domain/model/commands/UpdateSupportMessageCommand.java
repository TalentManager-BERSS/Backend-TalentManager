package com.berss.platform.support.domain.model.commands;

import com.berss.platform.support.domain.model.entities.Status;
import com.berss.platform.support.domain.model.valueobjects.SupportStatus;

public record UpdateSupportMessageCommand(Long id, Long companyId, String content) {
    public UpdateSupportMessageCommand {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("SupportMessage ID cannot be null or less than 1");
        }
        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("Company ID cannot be null or less than 1");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }

    }


}
