package com.berss.platform.business.interfaces.rest.resources;

/**
 * Update manager resource.
 */
public record UpdateManagerResource(String firstname, String lastname) {
    /**
     * Validates the resource.
     * @throws IllegalArgumentException if the firstname is null or blank.
     */
    public UpdateManagerResource {
        if (firstname == null || firstname.isBlank()) {
            throw new IllegalArgumentException("FirstName is required");
        }
        if (lastname == null || lastname.isBlank()) {
            throw new IllegalArgumentException("FirstName is required");
        }
    }
}
