package com.berss.platform.support.domain.model.queries;

public record GetSupportMessagesByCompanyIdQuery(Long companyId) {
    public GetSupportMessagesByCompanyIdQuery {
        if (companyId == null || companyId <= 0)
            throw new IllegalArgumentException("Company ID must be positive.");
    }
}
