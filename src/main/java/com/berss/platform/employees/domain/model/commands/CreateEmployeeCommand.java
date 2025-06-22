package com.berss.platform.employees.domain.model.commands;

import java.time.LocalDate;

public record CreateEmployeeCommand(String firstName, String lastName, String occupation, LocalDate entryDate, String teamName, Long companyId) {
    public CreateEmployeeCommand{

    }
}
