package com.berss.platform.employees.interfaces.rest.resources;


import java.time.LocalDate;

public record UpdateEmployeeResource(String firstName, String lastName, String occupation, LocalDate entryDate, String teamName) {
    public UpdateEmployeeResource{
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("FirstName is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("LastName is required");
        }
        if (occupation == null || occupation.isBlank()) {
            throw new IllegalArgumentException("Occupation is required");
        }
        if (entryDate == null) {
            throw new IllegalArgumentException("EntryDate is required");
        }
        if (teamName == null || teamName.isBlank()) {
            throw new IllegalArgumentException("TeamName is required");
        }
    }
}
