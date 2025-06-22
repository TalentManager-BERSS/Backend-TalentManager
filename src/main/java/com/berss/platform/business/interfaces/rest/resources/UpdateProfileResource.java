package com.berss.platform.business.interfaces.rest.resources;

/**
 * Update profile resource.
 */
public record UpdateProfileResource(String username) {
    /**
     * Validates the resource.
     * @throws IllegalArgumentException if the username is null or blank.
     */
    public UpdateProfileResource {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }
    }
}
