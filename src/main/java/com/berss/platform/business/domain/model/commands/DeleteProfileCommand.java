package com.berss.platform.business.domain.model.commands;

/**
 * Command to delete a profile.
 * @param profileId the profile id.
 *                  Cannot be null or less than 1
 */
public record DeleteProfileCommand(Long profileId) {
    /**
     * Constructor
     * @param profileId the profile id.
     *                  Cannot be null or less than 1
     * @throws IllegalArgumentException if profileId is null or less than 1
     */
    public DeleteProfileCommand {
        if (profileId == null || profileId <= 0) {
            throw new IllegalArgumentException("profileId cannot be null or less than 1");
        }
    }
}
