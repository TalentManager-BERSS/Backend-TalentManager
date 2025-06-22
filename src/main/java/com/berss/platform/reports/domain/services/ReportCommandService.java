package com.berss.platform.reports.domain.services;

import com.berss.platform.reports.domain.model.aggregates.Report;

import com.berss.platform.reports.domain.model.commands.CreateReportCommand;
import com.berss.platform.reports.domain.model.commands.UpdateReportCommand;
import com.berss.platform.reports.domain.model.commands.DeleteReportCommand;

import java.util.Optional;

/**
 * ReportCommandService
 * Service that handles report commands
 */
public interface ReportCommandService {
    Long handle(CreateReportCommand command);

    Optional<Report> handle(UpdateReportCommand command);
    Optional<Report> handle(DeleteReportCommand command);
}
