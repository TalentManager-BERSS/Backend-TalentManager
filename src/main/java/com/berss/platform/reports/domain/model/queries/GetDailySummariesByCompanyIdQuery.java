package com.berss.platform.reports.domain.model.queries;
import com.berss.platform.shared.domain.model.valueobjects.CompanyId;

public record GetDailySummariesByCompanyIdQuery(CompanyId companyId) {
    public GetDailySummariesByCompanyIdQuery {
        if (companyId == null)
            throw new IllegalArgumentException("Company ID must be positive and not null");
    }
}