package com.berss.platform.reports.domain.model.aggregates;

import com.berss.platform.reports.domain.model.commands.UpdateReportCommand;
import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.berss.platform.shared.domain.model.valueobjects.CompanyId;
import com.berss.platform.reports.domain.model.valueobjects.MonthlySummaryId;

import jakarta.persistence.*;

import com.berss.platform.reports.domain.model.commands.CreateReportCommand;
import lombok.Getter;

@Entity
public class Report extends AuditableAbstractAggregateRoot<Report> {

    @Getter
    private String title;

    @Getter
    @Column(columnDefinition = "TEXT")
    private String content;

    @Embedded
    @AttributeOverride(name = "companyId", column = @Column(name = "company_id"))
    private CompanyId companyId;

    @Getter
    @Embedded
    @AttributeOverride(name = "monthlySummaryId", column = @Column(name = "monthly_summary_id"))
    private MonthlySummaryId monthlySummaryId;

    // Constructors

    public Report() {}

    public Report(String title, String content, Long companyId, Long monthlySummaryId) {
        this.title = title;
        this.content = content;
        this.companyId = new CompanyId(companyId);
        this.monthlySummaryId = new MonthlySummaryId(monthlySummaryId);
    }

    public Report(CreateReportCommand command) {
        this.title = command.title();
        this.content = command.content();
        this.companyId = new CompanyId(command.companyId());
        this.monthlySummaryId = new MonthlySummaryId(command.monthlySummaryId());
    }

    public Long getCompanyId() {
        return companyId.getValue();
    }

    public Long getMonthlySummaryId() {
        return monthlySummaryId.getValue();
    }

    // Updaters

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
