package com.berss.platform.reports.domain.services;

import com.berss.platform.reports.domain.model.aggregates.MonthlySummary;

import com.berss.platform.reports.domain.model.commands.CreateMonthlySummaryCommand;
import com.berss.platform.reports.domain.model.commands.UpdateMonthlySummaryCommand;
import com.berss.platform.reports.domain.model.commands.DeleteMonthlySummaryCommand;
import com.berss.platform.reports.interfaces.rest.resources.CreateMonthlySummaryResource;

import java.util.Optional;

/**
 * MonthlySummaryCommandService
 * Service that handles monthly summary commands
 */
public interface MonthlySummaryCommandService {
    Long handle(CreateMonthlySummaryCommand command);
    Optional<MonthlySummary> handle(UpdateMonthlySummaryCommand command);
    void handle(DeleteMonthlySummaryCommand command);
}