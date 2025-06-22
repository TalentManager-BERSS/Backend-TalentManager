package com.berss.platform.reports.domain.services;

import java.util.List;
import java.util.Optional;

import com.berss.platform.reports.domain.model.aggregates.Report;

import com.berss.platform.reports.domain.model.queries.GetAllReportsQuery;
import com.berss.platform.reports.domain.model.queries.GetReportByIdQuery;
import com.berss.platform.reports.domain.model.queries.GetReportsByCompanyIdQuery;

public interface ReportQueryService {
    Optional<Report> handle(GetReportByIdQuery query);

    List<Report> handle(GetAllReportsQuery query);
    List<Report> handle(GetReportsByCompanyIdQuery query);
}
