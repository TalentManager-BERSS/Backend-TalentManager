package com.berss.platform.support.domain.model.aggregates;

import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

import com.berss.platform.support.domain.model.valueobjects.RequestDate;
import com.berss.platform.support.domain.model.valueobjects.CompanyId;

/**
 * SupportMessage Aggregate Root
 */
@Entity
public class SupportMessage extends AuditableAbstractAggregateRoot<SupportMessage> {

    private String message;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private RequestDate requestDate;

    /**
     * Default constructor
     */
    public SupportMessage() {}

    /**
     * Constructor with all fields
     */
    public SupportMessage(String message, Long companyId, RequestDate requestDate) {
        this.message = message;
        this.companyId = new CompanyId(companyId);
        this.requestDate = requestDate;
    }

    // Getters

    public String getMessage() {
        return message;
    }

    public Long getCompanyId() {
        return companyId.getValue();
    }

    public RequestDate getRequestDate() {
        return requestDate;
    }

    // Setters / Updaters

    public void updateMessage(String newMessage) {
        this.message = newMessage;
    }

    public void updateRequestDate(RequestDate newDate) {
        this.requestDate = newDate;
    }
}