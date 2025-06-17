package com.berss.platform.employees.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record TeamName(String name) {
    public TeamName {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
    }

    public String getValue() {
        return name;
    }
}
