package com.berss.platform.employees.domain.model.aggregates;

import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

/* Value Objects */
import com.berss.platform.employees.domain.model.valueobjects.EmployeeName;
import com.berss.platform.employees.domain.model.valueobjects.EntryDate;
import com.berss.platform.employees.domain.model.valueobjects.TeamId;
import com.berss.platform.employees.domain.model.valueobjects.CompanyId;

import java.time.LocalDate;

/**
 * Employee Aggregate Root
 */
@Entity
public class Employee extends AuditableAbstractAggregateRoot<Employee> {

    @Embedded
    private EmployeeName name;

    private String occupation;

    @Embedded
    private EntryDate entryDate;

    @Embedded
    private TeamId teamId;

    @Embedded
    private CompanyId companyId;

    /**
     * Constructor with all fields
     */
    public Employee(String firstName, String lastName, String occupation, LocalDate entryDate, Long teamId, Long companyId) {
        this.name = new EmployeeName(firstName, lastName);
        this.occupation = occupation;
        this.entryDate = new EntryDate(command.entryDate());
        this.teamId = new TeamId(teamId);
        this.companyId = new CompanyId(companyId);
    }

    /**
     * Default constructor
     */
    public Employee() {}

    /**
     * Constructor with a CreateEmployeeCommand
     */
    public Employee(CreateEmployeeCommand command) {
        this.name = new EmployeeName(command.firstName(), command.lastName());
        this.occupation = command.occupation();
        this.entryDate = command.entryDate();
        this.teamId = new TeamId(command.teamId());
        this.companyId = new CompanyId(command.companyId());
    }

    // Getters

    public String getFullName() {
        return name.getFullName();
    }

    public String getOccupation() {
        return occupation;
    }

    public EntryDate getEntryDate() {
        return entryDate;
    }

    public Long getTeamId() {
        return teamId.getValue();
    }

    public Long getCompanyId() {
        return companyId.getValue();
    }

    // Setters / Updaters

    public void updateName(String firstName, String lastName) {
        this.name = new EmployeeName(firstName, lastName);
    }

    public void updateOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void updateEntryDate(LocalDate newDate) {
        this.entryDate = new EntryDate(newDate);
    }

    public void updateTeamId(Long teamId) {
        this.teamId = new TeamId(teamId);
    }

    public void updateCompanyId(Long companyId) {
        this.companyId = new CompanyId(companyId);
    }
}