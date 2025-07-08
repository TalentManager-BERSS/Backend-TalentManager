package com.berss.platform.reports.domain.services;

import com.berss.platform.reports.domain.model.aggregates.DailySummary;
import com.berss.platform.reports.domain.model.queries.GetAllDailySummariesQuery;
import com.berss.platform.reports.domain.model.queries.GetDailySummariesByCompanyIdQuery;
import com.berss.platform.reports.domain.model.queries.GetDailySummariesByEmployeeIdQuery;
import com.berss.platform.reports.domain.model.queries.GetDailySummaryByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * DailySummaryQueryService
 * Service that handles monthly summary queries
 */

public interface DailySummaryQueryService {
    Optional<DailySummary> handle(GetDailySummaryByIdQuery query);

    List<DailySummary> handle(GetAllDailySummariesQuery query);
    List<DailySummary> handle(GetDailySummariesByEmployeeIdQuery query);
    List<DailySummary> handle(GetDailySummariesByCompanyIdQuery query);
}
