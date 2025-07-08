package com.berss.platform.reports.application.internal.queryservices;

import com.berss.platform.reports.domain.model.aggregates.DailySummary;
import com.berss.platform.reports.domain.model.queries.GetAllDailySummariesQuery;
import com.berss.platform.reports.domain.model.queries.GetDailySummariesByCompanyIdQuery;
import com.berss.platform.reports.domain.model.queries.GetDailySummariesByEmployeeIdQuery;
import com.berss.platform.reports.domain.model.queries.GetDailySummaryByIdQuery;
import com.berss.platform.reports.domain.services.DailySummaryQueryService;
import com.berss.platform.reports.infrastructure.persistence.jpa.repositories.DailySummaryRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailySummaryQueryServiceImpl implements DailySummaryQueryService {

    private final DailySummaryRepository repository;

    public DailySummaryQueryServiceImpl(DailySummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DailySummary> handle(GetAllDailySummariesQuery query) {
        return repository.findAll();
    }

    @Override
    public Optional<DailySummary> handle(GetDailySummaryByIdQuery query) {
        return repository.findById(query.dailySummaryId());
    }

    @Override
    public List<DailySummary> handle(GetDailySummariesByCompanyIdQuery query) {
        return repository.findDailySummariesByCompanyId(query.companyId());
    }

    @Override
    public List<DailySummary> handle(GetDailySummariesByEmployeeIdQuery query) {
        return repository.findDailySummariesByEmployeeId(query.employeeId());
    }

}
