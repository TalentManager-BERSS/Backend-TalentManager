package com.berss.platform.reports.domain.model.queries;

import com.berss.platform.reports.domain.model.valueobjects.CompanyId;

public record GetMonthlySummariesByCompanyIdQuery(CompanyId companyId) {
    public GetMonthlySummariesByCompanyIdQuery {
        if (companyId == null)
            throw new IllegalArgumentException("Company ID must be positive and not null");
    }
}