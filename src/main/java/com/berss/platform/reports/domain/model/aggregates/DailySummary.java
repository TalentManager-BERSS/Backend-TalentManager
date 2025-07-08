package com.berss.platform.reports.domain.model.aggregates;

import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.berss.platform.shared.domain.model.valueobjects.CompanyId;
import jakarta.persistence.*;

// Value Objects

import com.berss.platform.reports.domain.model.valueobjects.EmployeeId;
import com.berss.platform.reports.domain.model.valueobjects.Score;
import com.berss.platform.reports.domain.model.valueobjects.InputAmount;
import com.berss.platform.shared.domain.model.valueobjects.SpecificDate;

// Commands
import com.berss.platform.reports.domain.model.commands.CreateDailySummaryCommand;
import com.berss.platform.reports.domain.model.commands.UpdateDailySummaryCommand;

import java.time.LocalDate;

/**
 * Daily Summary aggregate root
 */
@Entity
public class DailySummary extends AuditableAbstractAggregateRoot<DailySummary> {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "employee_id"))
    private EmployeeId employeeId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "company_id"))
    private CompanyId companyId;

    @Embedded
    private SpecificDate specificDate;

    private Integer entryTime;

    private Integer exitTime;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "score"))
    private Score score;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "input"))
    private InputAmount inputAmount;

    /**
     * Default constructor
     */
    public DailySummary() {}

    /**
     * Constructor with all fields
     */
    public DailySummary(Long employeeId, Long companyId, int _day, int _month, int _year, int _entryTime, int _exitTime, double _inputAmount, int _score) {
        this.employeeId = new EmployeeId(employeeId);
        this.companyId = new CompanyId(companyId);
        this.specificDate = new SpecificDate(_day, _month, _year);
        this.entryTime = _entryTime;
        this.exitTime = _exitTime;
        this.inputAmount = new InputAmount(_inputAmount);
        this.score = new Score(_score);
    }

    /**
     * Constructor with CreateDailySummaryCommand
     */
    public DailySummary(CreateDailySummaryCommand command) {
        this.employeeId = new EmployeeId(command.employeeId());
        this.companyId = new CompanyId(command.companyId());
        this.specificDate = new SpecificDate(command.day(), command.month(), command.year());
        this.entryTime = command.entryTime();
        this.exitTime = command.exitTime();
        this.inputAmount = new InputAmount(command.inputAmount());
        this.score = new Score(command.score());
    }

    // Getters

    public double getInput() {
        return inputAmount.getValue();
    }

    public int getScore() {
        return score.getValue();
    }

    public long getEmployeeId() {
        return employeeId.getValue();
    }

    public long getCompanyId() {
        return companyId.getValue();
    }

    public InputAmount getInputAmount() { return inputAmount; }

    public Integer getDay() { return specificDate.day(); }

    public Integer getMonth() { return specificDate.month(); }

    public Integer getYear() { return specificDate.year(); }

    public LocalDate getLocalDate() { return specificDate.toLocalDate(); }

    public Integer getEntryTime() { return entryTime; }

    public Integer getExitTime() { return exitTime; }

    // Setters / Updaters

    public void updateEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }

    public void updateExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public void updateScore(int value) {
        this.score = new Score(value);
    }

    public void updateInput(double value) {
        this.inputAmount = new InputAmount(value);
    }

    /**
     * Updater with UpdateDailySummaryCommand
     */
    public void updateDailySummary(UpdateDailySummaryCommand command) {
        this.entryTime = command.entryTime();
        this.exitTime = command.exitTime();
        this.score = new Score(command.score());
        this.inputAmount = new InputAmount(command.inputAmount());
    }
}
