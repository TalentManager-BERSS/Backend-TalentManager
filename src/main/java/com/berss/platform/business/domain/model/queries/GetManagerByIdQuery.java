package com.berss.platform.business.domain.model.queries;

public record GetManagerByIdQuery(Long managerId) {
    /**
     * Constructor.
     * @param managerId Manager id.
     *                  Must be greater than 0.
     *                  Must not be null.
     * @throws IllegalArgumentException If the manager ID is invalid.
     */
    public GetManagerByIdQuery {
        if (managerId == null || managerId <= 0) {
            throw new IllegalArgumentException("Manager id is required.");
        }
    }
}