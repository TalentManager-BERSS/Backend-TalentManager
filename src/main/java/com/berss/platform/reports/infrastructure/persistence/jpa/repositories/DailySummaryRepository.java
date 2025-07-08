package com.berss.platform.reports.infrastructure.persistence.jpa.repositories;

import com.berss.platform.reports.domain.model.aggregates.DailySummary;
import com.berss.platform.reports.domain.model.valueobjects.EmployeeId;
import com.berss.platform.shared.domain.model.valueobjects.CompanyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DailySummaryRepository extends JpaRepository<DailySummary, Long> {
    Optional<DailySummary> findDailySummariesById(Long id);
    List<DailySummary> findDailySummariesByEmployeeId(EmployeeId employeeId);
    List<DailySummary> findDailySummariesByCompanyId(CompanyId companyId);

    boolean existsDailySummariesById(Long id);
}
