package com.berss.platform.employees.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record TeamName(String teamName) {
    public TeamName {
        if (teamName == null || teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
    }

    public String getValue() {
        return teamName;
    }
}
