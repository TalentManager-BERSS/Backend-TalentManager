package com.berss.platform.employees.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the team id.
 * @summary
 * This value object is used to represent the team id. It is an embeddable object that is used to represent the team id in the employee aggregate.
 * It throws an IllegalArgumentException if the team id is null or less than 1.
 * @param teamId The team id. It cannot be null or less than 1.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record TeamId(Long teamId) {
    public TeamId {
        if (teamId == null || teamId < 1) {
            throw new IllegalArgumentException("Team id cannot be null or less than 1");
        }
    }

    public Long getValue() {
        return teamId;
    }
}