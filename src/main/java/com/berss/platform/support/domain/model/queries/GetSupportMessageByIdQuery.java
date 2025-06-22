package com.berss.platform.support.domain.model.queries;

public record GetSupportMessageByIdQuery(Long id) {
    public GetSupportMessageByIdQuery {
        if (id == null || id <= 0)
            throw new IllegalArgumentException("ID must be positive and non-null.");
    }
}
