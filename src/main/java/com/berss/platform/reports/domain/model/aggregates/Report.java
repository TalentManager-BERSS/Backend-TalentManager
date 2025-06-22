package com.berss.platform.reports.domain.model.aggregates;

import com.berss.platform.reports.domain.model.commands.UpdateReportCommand;
import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import java.time.LocalDate;

/* Value Objects */
import com.berss.platform.reports.domain.model.valueobjects.CompanyId;
import com.berss.platform.reports.domain.model.valueobjects.CreationDate;

/* Commands */
import com.berss.platform.reports.domain.model.commands.CreateReportCommand;
import lombok.Getter;

/**
 * Report Aggregate Root
 */
@Entity
public class Report extends AuditableAbstractAggregateRoot<Report> {

    @Getter
    private String title;

    @Getter
    @Column(columnDefinition = "TEXT")
    private String content;

    @Embedded
    @Column(name = "createdAt")
    private CreationDate createdAt;

    @Embedded
    @Column(name = "companyId")
    private CompanyId companyId;

    /**
     * Default constructor
     */
    public Report() {}

    /**
     * Constructor with all fields
     */
    public Report(String title, String content, LocalDate createdAt, Long companyId) {
        this.title = title;
        this.content = content;
        this.createdAt = new CreationDate(createdAt);
        this.companyId = new CompanyId(companyId);
    }

    /**
     * Constructor with CreateReportCommand
     */
    public Report(CreateReportCommand command) {
        this.title = command.title();
        this.content = command.content();
        this.createdAt = new CreationDate(command.createdAt());
        this.companyId = new CompanyId(command.companyId());
    }

    // Getters

    public LocalDate getCreationDate() {
        return createdAt.getValue();
    }

    public Long getCompanyId() {
        return companyId.getValue();
    }

    // Setters / Updaters

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateCreatedAt(LocalDate newDate) {
        this.createdAt = new CreationDate(newDate);
    }

    public void updateReport(UpdateReportCommand command) {
        this.title = command.title();
        this.content = command.content();
    }
}