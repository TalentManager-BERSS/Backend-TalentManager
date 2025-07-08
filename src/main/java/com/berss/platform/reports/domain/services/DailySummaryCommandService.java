package com.berss.platform.reports.domain.services;

import com.berss.platform.reports.domain.model.aggregates.DailySummary;
import com.berss.platform.reports.domain.model.commands.CreateDailySummaryCommand;
import com.berss.platform.reports.domain.model.commands.DeleteDailySummaryCommand;
import com.berss.platform.reports.domain.model.commands.UpdateDailySummaryCommand;

import java.util.Optional;
/**
 * DailySummaryCommandService
 * Service that handles monthly summary commands
 */
public interface DailySummaryCommandService {
    Long handle(CreateDailySummaryCommand command);
    Optional<DailySummary> handle(UpdateDailySummaryCommand command);
    void handle(DeleteDailySummaryCommand command);
}