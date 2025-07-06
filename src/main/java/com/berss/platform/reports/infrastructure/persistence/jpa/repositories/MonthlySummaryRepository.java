package com.berss.platform.reports.infrastructure.persistence.jpa.repositories;

import com.berss.platform.reports.domain.model.aggregates.MonthlySummary;
import com.berss.platform.reports.domain.model.valueobjects.EmployeeId;
import com.berss.platform.shared.domain.model.valueobjects.CompanyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonthlySummaryRepository extends JpaRepository<MonthlySummary, Long> {
    Optional<MonthlySummary> findMonthlySummariesById(Long id);
    List<MonthlySummary> findMonthlySummariesByEmployeeId(EmployeeId employeeId);
    List<MonthlySummary> findMonthlySummariesByCompanyId(CompanyId companyId);

    boolean existsMonthlySummariesById(Long id);
    boolean existsMonthlySummariesByEmployeeIdAndPeriod_MonthAndPeriod_Year(EmployeeId employeeId, int periodMonth, int periodYear);
}
