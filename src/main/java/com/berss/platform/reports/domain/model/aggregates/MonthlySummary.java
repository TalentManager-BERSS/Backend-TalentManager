package com.berss.platform.reports.domain.model.aggregates;

import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

import com.berss.platform.reports.domain.model.valueobjects.YearMonthPeriod;

/**
 * Monthly Summary aggregate root
 */
@Entity
public class MonthlySummary extends AuditableAbstractAggregateRoot<MonthlySummary> {

    private Long employeeId;

    @Embedded
    private YearMonthPeriod period;

    private int totalHours;
    private int completedHours;

    private double input;
    private double score;

    public MonthlySummary() {}

    public MonthlySummary(Long employeeId, YearMonthPeriod period, int totalHours, int completedHours, double input, double score) {
        this.employeeId = employeeId;
        this.period = period;
        this.totalHours = totalHours;
        this.completedHours = completedHours;
        this.input = input;
        this.score = score;
    }

    // Getters

    public Long getEmployeeId() {
        return employeeId;
    }

    public YearMonthPeriod getPeriod() {
        return period;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public int getCompletedHours() {
        return completedHours;
    }

    public double getInput() {
        return input;
    }

    public double getScore() {
        return score;
    }

    // Setters / Updaters

    public void updateTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void updateCompletedHours(int completedHours) {
        this.completedHours = completedHours;
    }

    public void updateInput(double input) {
        this.input = input;
    }

    public void updateScore(double score) {
        this.score = score;
    }
}
