package com.berss.platform.reports.domain.model.aggregates;

import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import java.time.LocalDate;

/* Value Objects */
import com.berss.platform.reports.domain.model.valueobjects.CompanyId;
import com.berss.platform.reports.domain.model.valueobjects.CreationDate;
import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Report Aggregate Root
 */
@Entity
public class Report extends AuditableAbstractAggregateRoot<Report> {

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Embedded
    private CreationDate createdAt;

    @Embedded
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
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreatedAt() {
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
}