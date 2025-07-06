package com.berss.platform.employees.domain.model.aggregates;

import com.berss.platform.employees.domain.model.commands.CreateEmployeeCommand;
import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.berss.platform.shared.domain.model.valueobjects.CompanyId;
import jakarta.persistence.*;

/* Value Objects */
import com.berss.platform.employees.domain.model.valueobjects.EmployeeName;
import com.berss.platform.employees.domain.model.valueobjects.EntryDate;
import com.berss.platform.employees.domain.model.valueobjects.TeamName;

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
    private TeamName teamName;

    @Embedded
    private CompanyId companyId;

    /**
     * Constructor with all fields
     */
    public Employee(String firstName, String lastName, String occupation, LocalDate entryDate, String teamName, Long companyId) {
        this.name = new EmployeeName(firstName, lastName);
        this.occupation = occupation;
        this.entryDate = new EntryDate(entryDate);
        this.teamName = new TeamName(teamName);
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
        this.entryDate = new EntryDate(command.entryDate());
        this.teamName = new TeamName(command.teamName());
        this.companyId = new CompanyId(command.companyId());
    }

    // Getters

    public String getFullName() {
        return name.getFullName();
    }

    public String getFirstName() { return name.firstName();}

    public String getLastName() { return name.lastName();}

    public String getOccupation() {
        return occupation;
    }

    public LocalDate getEntryDate() {
        return entryDate.entryDate();
    }

    public String getTeamName() { return teamName.getValue(); }

    public Long getCompanyId() {
        return companyId.getValue();
    }

    // Setters / Updaters


    public Employee updateInformation(String firstName, String lastName, String occupation, LocalDate entryDate, String teamName){
        this.name = new EmployeeName(firstName, lastName);
        this.occupation = occupation;
        this.entryDate = new EntryDate(entryDate);
        this.teamName = new TeamName(teamName);
        return this;
    }

    public void updateName(String firstName, String lastName) {
        this.name = new EmployeeName(firstName, lastName);
    }

    public void updateOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void updateEntryDate(LocalDate newDate) {
        this.entryDate = new EntryDate(newDate);
    }

    public void updateTeamName(String newTeamName) {
        this.teamName = new TeamName(newTeamName);
    }

    public void updateCompanyId(Long companyId) {
        this.companyId = new CompanyId(companyId);
    }

}