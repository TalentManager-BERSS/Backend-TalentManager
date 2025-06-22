package com.berss.platform.reports.application.internal.queryservices;

import com.berss.platform.reports.domain.model.aggregates.MonthlySummary;
import com.berss.platform.reports.domain.model.queries.GetAllMonthlySummariesQuery;
import com.berss.platform.reports.domain.model.queries.GetMonthlySummariesByCompanyIdQuery;
import com.berss.platform.reports.domain.model.queries.GetMonthlySummariesByEmployeeIdQuery;
import com.berss.platform.reports.domain.model.queries.GetMonthlySummaryByIdQuery;
import com.berss.platform.reports.domain.services.MonthlySummaryQueryService;
import com.berss.platform.reports.infrastructure.persistence.jpa.repositories.MonthlySummaryRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlySummaryQueryServiceImpl implements MonthlySummaryQueryService {

    private final MonthlySummaryRepository repository;

    public MonthlySummaryQueryServiceImpl(MonthlySummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MonthlySummary> handle(GetAllMonthlySummariesQuery query) {
        return repository.findAll();
    }

    @Override
    public Optional<MonthlySummary> handle(GetMonthlySummaryByIdQuery query) {
        return repository.findById(query.monthlySummaryId());
    }

    @Override
    public List<MonthlySummary> handle(GetMonthlySummariesByCompanyIdQuery query) {
        return repository.findMonthlySummariesByCompanyId(query.companyId());
    }

    @Override
    public List<MonthlySummary> handle(GetMonthlySummariesByEmployeeIdQuery query) {
        return repository.findMonthlySummariesByEmployeeId(query.employeeId());
    }

}
