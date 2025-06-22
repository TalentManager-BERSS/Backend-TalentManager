package com.berss.platform.reports.application.internal.queryservices;

import com.berss.platform.reports.domain.model.aggregates.Report;
import com.berss.platform.reports.domain.model.queries.GetAllReportsQuery;
import com.berss.platform.reports.domain.model.queries.GetReportByIdQuery;
import com.berss.platform.reports.domain.model.queries.GetReportsByCompanyIdQuery;
import com.berss.platform.reports.domain.services.ReportQueryService;
import com.berss.platform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportQueryServiceImpl implements ReportQueryService {

    private final ReportRepository reportRepository;

    public ReportQueryServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Optional<Report> handle(GetReportByIdQuery query) {
        return reportRepository.findById(query.reportId());
    }

    @Override
    public List<Report> handle(GetAllReportsQuery query) {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> handle(GetReportsByCompanyIdQuery query) {
        return reportRepository.findReportByCompanyId(query.companyId());
    }
}
