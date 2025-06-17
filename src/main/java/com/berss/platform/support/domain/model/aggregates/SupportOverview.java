package com.berss.platform.support.domain.model.aggregates;

import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.berss.platform.support.domain.model.commands.CreateSupportOverviewCommand;

import com.berss.platform.support.domain.model.valueobjects.SupportMessageId;
import com.berss.platform.support.domain.model.valueobjects.SupportStatus;
import com.berss.platform.support.domain.model.valueobjects.ReceivedAt;
import com.berss.platform.support.domain.model.valueobjects.CompanyId;

import jakarta.persistence.*;

/**
 * Aggregate root representing the processing overview of a support message.
 */
@Entity
public class SupportOverview extends AuditableAbstractAggregateRoot<SupportOverview> {

    @Embedded
    private SupportMessageId messageId;

    @Embedded
    private CompanyId companyId;

    @Enumerated(EnumType.STRING)
    private SupportStatus status;

    @Embedded
    private ReceivedAt receivedAt;

    public SupportOverview() {}

    public SupportOverview(CreateSupportOverviewCommand command) {
        this.messageId = new SupportMessageId(command.messageId());
        this.companyId = new CompanyId(command.companyId());
        this.status = command.status();
        this.receivedAt = new ReceivedAt(command.receivedAt());
    }

    public SupportOverview(CreateSupportOverviewCommand command) {
        this.messageId = new SupportMessageId(command.messageId());
        this.companyId = new CompanyId(command.companyId());
        this.status = new SupportStatus(command.status());
        this.receivedAt = new ReceivedAt(command.receivedAt());
    }

    // Getters
    public Long getMessageId() {
        return messageId.value();
    }

    public Long getCompanyId() {
        return companyId.getValue();
    }

    public String getStatus() {
        return this.status.name();
    }

    public java.time.LocalDateTime getReceivedAt() {
        return receivedAt.value();
    }

    // State transitions
    public void updateStatus(SupportStatus newStatus) {
        if (newStatus == null) throw new IllegalArgumentException("Status cannot be null");
        this.status = newStatus;
    }
}
