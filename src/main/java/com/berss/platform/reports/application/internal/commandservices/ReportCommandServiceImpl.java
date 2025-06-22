package com.berss.platform.reports.application.internal.commandservices;

import com.berss.platform.reports.domain.model.aggregates.Report;
import com.berss.platform.reports.domain.model.commands.CreateReportCommand;
import com.berss.platform.reports.domain.model.commands.DeleteReportCommand;
import com.berss.platform.reports.domain.model.commands.UpdateReportCommand;
import com.berss.platform.reports.domain.services.ReportCommandService;
import com.berss.platform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportCommandServiceImpl implements ReportCommandService {

    private final ReportRepository reportRepository;

    public ReportCommandServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Long handle(CreateReportCommand command) {
        var report = new Report(command);
        var savedReport = reportRepository.save(report);
        return savedReport.getId();
    }

    @Override
    public Optional<Report> handle(UpdateReportCommand command) {
        var reportOptional = reportRepository.findById(command.reportId());
        if (reportOptional.isEmpty()) return Optional.empty();

        var report = reportOptional.get();
        report.updateReport(command);
        return Optional.of(reportRepository.save(report));
    }

    @Override
    public Optional<Report> handle(DeleteReportCommand command) {
        var reportOptional = reportRepository.findById(command.reportId());
        reportOptional.ifPresent(reportRepository::delete);
        return reportOptional;
    }
}