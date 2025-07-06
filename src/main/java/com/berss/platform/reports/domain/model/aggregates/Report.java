package com.berss.platform.reports.domain.model.aggregates;

import com.berss.platform.reports.domain.model.commands.UpdateReportCommand;
import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.berss.platform.shared.domain.model.valueobjects.CompanyId;
import jakarta.persistence.*;

/* Value Objects */

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
    @Column(name = "companyId")
    private CompanyId companyId;

    /**
     * Default constructor
     */
    public Report() {}

    /**
     * Constructor with all fields
     */
    public Report(String title, String content, Long companyId) {
        this.title = title;
        this.content = content;
        this.companyId = new CompanyId(companyId);
    }

    /**
     * Constructor with CreateReportCommand
     */
    public Report(CreateReportCommand command) {
        this.title = command.title();
        this.content = command.content();
        this.companyId = new CompanyId(command.companyId());
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

    public void updateReport(UpdateReportCommand command) {
        this.title = command.title();
        this.content = command.content();
    }
}