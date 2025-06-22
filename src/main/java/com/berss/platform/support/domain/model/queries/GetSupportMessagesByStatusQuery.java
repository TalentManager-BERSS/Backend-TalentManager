package com.berss.platform.support.domain.model.queries;

import com.berss.platform.support.domain.model.valueobjects.SupportStatus;

public record GetSupportMessagesByStatusQuery(SupportStatus status) {
    public GetSupportMessagesByStatusQuery {
        if (status == null)
            throw new IllegalArgumentException("Status must not be null.");
    }
}
