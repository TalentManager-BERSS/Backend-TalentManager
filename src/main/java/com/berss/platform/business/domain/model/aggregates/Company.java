package com.berss.platform.business.domain.model.aggregates;

import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

import com.berss.platform.business.domain.model.valueobjects.CompanyStatus;
import com.berss.platform.business.domain.model.valueobjects.CompanyWebsite;

/*
 Company Aggregate Root
 */
@Entity
public class Company extends AuditableAbstractAggregateRoot<Company> {

    private String name;

    private String description;

    private String email;

    @Embedded
    private CompanyWebsite website;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status;

    /**
     * Default constructor
     */
    public Company() {}

    /**
     * Full constructor
     */
    public Company(String name, String description, String email, String website, CompanyStatus status) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.website = new CompanyWebsite(website);
        this.status = status;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website.address();
    }

    public CompanyStatus getStatus() {
        return status;
    }

    // Updaters

    public void updateName(String name) {
        this.name = name;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateWebsite(String website) {
        this.website = new CompanyWebsite(website);
    }

    public void updateStatus(CompanyStatus status) {
        this.status = status;
    }
}
