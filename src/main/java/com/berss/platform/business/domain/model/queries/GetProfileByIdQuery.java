package com.berss.platform.business.domain.model.queries;

public record GetProfileByIdQuery(Long profileId) {
    /**
     * Constructor.
     * @param profileId Profile id.
     *                  Must be greater than 0.
     *                  Must not be null.
     * @throws IllegalArgumentException If the profile ID is invalid.
     */
    public GetProfileByIdQuery {
        if (profileId == null || profileId <= 0) {
            throw new IllegalArgumentException("Profile id is required.");
        }
    }
}