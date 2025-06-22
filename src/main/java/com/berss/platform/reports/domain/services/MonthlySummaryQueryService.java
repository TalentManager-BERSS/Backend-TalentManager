package com.berss.platform.reports.domain.services;

import java.util.List;
import java.util.Optional;

import com.berss.platform.reports.domain.model.aggregates.MonthlySummary;

import com.berss.platform.reports.domain.model.queries.GetAllMonthlySummariesQuery;
import com.berss.platform.reports.domain.model.queries.GetMonthlySummaryByIdQuery;
import com.berss.platform.reports.domain.model.queries.GetMonthlySummariesByCompanyIdQuery;
import com.berss.platform.reports.domain.model.queries.GetMonthlySummariesByEmployeeIdQuery;


/**
 * MonthlySummaryQueryService
 * Service that handles monthly summary queries
 */

public interface MonthlySummaryQueryService {
    Optional<MonthlySummary> handle(GetMonthlySummaryByIdQuery query);

    List<MonthlySummary> handle(GetAllMonthlySummariesQuery query);
    List<MonthlySummary> handle(GetMonthlySummariesByCompanyIdQuery query);
    List<MonthlySummary> handle(GetMonthlySummariesByEmployeeIdQuery query);
}
