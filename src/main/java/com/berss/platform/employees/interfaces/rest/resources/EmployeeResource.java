package com.berss.platform.employees.interfaces.rest.resources;

import java.time.LocalDate;

public record EmployeeResource(Long id, String firstName, String lastName, String occupation, LocalDate entryDate, String teamName, Long companyId) {
}
